
#include "mlp.hpp"

using namespace std;
using namespace mxnet::cpp;

MLPNative::MLPNative() {
  ctx_dev = Context(DeviceType::kCPU, 0);
}

void MLPNative::setLayers(int * lsize, int nsize, int n) {
  nLayers = nsize;
  nOut = n;
  for (int i = 0; i < nsize; i++) {
    layerSize.push_back(lsize[i]);
  }
  pred = (mx_float *)malloc(sizeof(mx_float) * dimY * nOut);
}

void MLPNative::setAct(char ** acts) {
  for (int i = 0; i < nLayers; i++) {
    activations.push_back(acts[i]);
  }
}

void MLPNative::setData(mx_float * aptr_x, int dim1, int dim2) {
  dimX1 = dim1;
  dimX2 = dim2;
  array_x = NDArray(Shape(dimX1, dimX2), ctx_dev, false);
  array_x.SyncCopyFromCPU(aptr_x, dimX1 * dimX2);
  array_x.WaitToRead();
}

void MLPNative::setLabel(mx_float * aptr_y, int i) {
  dimY = i;
  array_y = NDArray(Shape(dimY), ctx_dev, false);
  array_y.SyncCopyFromCPU(aptr_y, dimY);
  array_y.WaitToRead();
  label.assign(aptr_y, aptr_y + dimY);
}

void MLPNative::build_mlp() {
  Symbol act = Symbol::Variable("data");
  Symbol data_label = Symbol::Variable("data_label");
  std::vector<Symbol> fc_w, fc_b, fc;

  for (int i = 0; i < nLayers; i++) {
    fc_w.push_back(Symbol("fc" + std::to_string(i + 1) + "_w"));
    fc_b.push_back(Symbol("fc" + std::to_string(i + 1) + "_b"));
    fc.push_back(FullyConnected("fc" + std::to_string(i + 1), 
                                act, fc_w[i], fc_b[i], layerSize[i]));
    act = Activation("act" + std::to_string(i + 1),
                     fc[i], activations[i]);
  }
  fc_w.push_back(Symbol("fc" + std::to_string(nLayers + 1) + "_w"));
  fc_b.push_back(Symbol("fc" + std::to_string(nLayers + 1) + "_b"));
  fc.push_back(FullyConnected("fc" + std::to_string(nLayers + 1),
                              act, fc_w[nLayers], fc_b[nLayers], nOut));
  sym_network = SoftmaxOutput("softmax", fc[nLayers], data_label);
  sym_network.Save("mlp.json");
  args_map["data"] = array_x.Slice(0, batch_size).Copy(ctx_dev);
  args_map["data_label"] = array_y.Slice(0, batch_size).Copy(ctx_dev);
  sym_network.InferArgsMap(ctx_dev, &args_map, args_map);
}

mx_float MLPNative::compAccuracy() {
  size_t val_num = array_x.GetShape()[0];
  size_t correct_count = 0;
  size_t all_count = 0;

  size_t start_index = 0;
  while (start_index < val_num) {
    if (start_index + batch_size > val_num) {
      start_index = val_num - batch_size;
    }
    args_map["data"] = array_x.Slice(start_index, start_index + batch_size).Copy(ctx_dev);
    args_map["data_label"] = array_y.Slice(start_index, start_index + batch_size).Copy(ctx_dev);
    start_index += batch_size;
    NDArray::WaitAll();

    Executor *exe = sym_network.SimpleBind(ctx_dev, args_map);
    exe->Forward(false);

    const auto &out = exe->outputs;
    NDArray outs = out[0].Copy(ctx_dev);
    NDArray labels = array_y.Slice(start_index - batch_size, start_index).Copy(ctx_dev);
    NDArray::WaitAll();

    const mx_float *dptr_out = outs.GetData();
    const mx_float *dptr_label = labels.GetData();
    for (int i = 0; i < batch_size; i++) {
      mx_float label = dptr_label[i];
      int cat_num = outs.GetShape()[1];
      mx_float p_label = 0, max_p = dptr_out[i * cat_num];
      for (int j = 0; j < cat_num; ++j) {
        mx_float p = dptr_out[i * cat_num + j];
        if (max_p < p) {
          p_label = j;
          max_p = p;
        }
      }
      if (label == p_label) correct_count++;
    }
    all_count += batch_size;

    delete exe;
  }
  return static_cast<mx_float>(correct_count) / all_count;
}

void MLPNative::train() {

  Optimizer opt("ccsgd", learning_rate, weight_decay);
  opt.SetParam("momentum", 0.9)
      .SetParam("rescale_grad", 1.0)
      .SetParam("clip_gradient", 10);

  int start_index = 0;
  while (start_index < dimY) {
    if (start_index + batch_size > dimY) {
      start_index = dimY - batch_size; 
    } 
    args_map["data"] = array_x.Slice(start_index, start_index + batch_size).Copy(ctx_dev);
    args_map["data_label"] = array_y.Slice(start_index, start_index + batch_size).Copy(ctx_dev);
    start_index += batch_size;
    NDArray::WaitAll();

    Executor * exe = sym_network.SimpleBind(ctx_dev, args_map);
    exe->Forward(true);
    exe->Backward();
    exe->UpdateAll(&opt, learning_rate, weight_decay);
    NDArray::WaitAll();
    if (start_index == dimY - batch_size) {
      std::vector<NDArray> & out = exe->outputs; 
      out[0].SyncCopyToCPU(pred, dimY * layerSize[layerSize.size() - 1]);
      NDArray::WaitAll();
    }
  }
}