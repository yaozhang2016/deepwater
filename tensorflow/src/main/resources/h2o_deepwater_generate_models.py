from __future__ import division
from __future__ import print_function

import os

import sys

import json

import tensorflow as tf
from tensorflow.python.framework import ops

from deepwater.models import (lenet, mlp, alexnet, vgg, inception, resnet)
from deepwater import train, optimizers

from functools import partial

tf.logging.set_verbosity(tf.logging.DEBUG)


def generate_models(name, model_class):
    height = [28, 32, 224]
    width = [28, 32, 224]
    channels = [1, 3]
    classes = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 1000]

    for (h, w) in zip(height, width):
        for ch in channels:
            for class_n in classes:
                filename = "%s_%dx%dx%d_%d" % (name, w, h, ch, class_n)
                model = model_class([h, w, ch], [class_n])
                model.export(filename + ".meta")


def export_train_graph(model_class, optimizer_class,
                       height, width, channels, classes, output=None):
    graph = tf.Graph()
    with graph.as_default():
        global_is_training = tf.placeholder(tf.bool, name="global_is_training")

        batch_size = tf.placeholder(tf.float32, [], name="batch_size")

        # 1. instantiate the model
        model = model_class(width, height, channels, classes)

        # 2. export train graph
        filename = "%s_%dx%dx%d_%d.meta" % (model.name.lower(),
                                            width,
                                            height,
                                            channels,
                                            classes)

        if output is not None:
            if not output.endswith('/'):
                output = output + '/'
            filename = output + filename

        if os.path.exists(filename):
            print("file %s exists. skipping" % filename)
            return

        # 3. instantiate the optimizer
        optimizer = optimizer_class()

        # 4. instantiate the train wrapper
        train_strategy = train.ImageClassificationTrainStrategy(
            graph,
            model,
            optimizer,
            batch_size,
            add_summaries=True,
        )

        saver = tf.train.Saver()
        init = tf.global_variables_initializer()
        tf.add_to_collection(ops.GraphKeys.INIT_OP, init.name)
        tf.add_to_collection(ops.GraphKeys.TRAIN_OP, train_strategy.optimize)
        tf.add_to_collection("logits", train_strategy.logits)
        tf.add_to_collection(ops.GraphKeys.SUMMARY_OP, train_strategy.summary_op)
        tf.add_to_collection("predictions", model.predictions)
        tf.add_to_collection(ops.GraphKeys.LOSSES, model.predictions)

        basic_params = {
            "inputs": {"batch_image_input": train_strategy.inputs.name,
                       "categorical_labels": train_strategy.labels.name},
            "outputs": {"categorical_logits": model.logits.name,
                        # This can be removed when TF Java API implements get_operations
                        "layers": ','.join([m.name for m in graph.get_operations()])},
            "metrics": {"accuracy": train_strategy.accuracy.name,
                        "total_loss": train_strategy.loss.name},
            "parameters": {
                "global_step": train_strategy.global_step.name,
                "learning_rate": train_strategy._optimizer.learning_rate.name,
                "momentum": train_strategy._optimizer.momentum.name,
                "batch_size": train_strategy._batch_size.name,
                "global_is_training": global_is_training.name},
        }

        if hasattr(model, 'hidden_dropout'):
            basic_params['parameters']['hidden_dropout'] = model._hidden_dropout.name

        if hasattr(model, 'input_dropout'):
            basic_params['parameters']['input_dropout'] = model._input_dropout.name

        if hasattr(model, 'activations'):
            basic_params['parameters']['activations'] = model._activations.name

        meta = json.dumps(basic_params)

        tf.add_to_collection("meta", meta)

        tf.train.export_meta_graph(filename=filename,
                                   saver_def=saver.as_saver_def())
        print("model exported to ", filename)


def export_linear_model_graph(model_class):
    classes = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 50, 100, 1000]

    for linear in [2, 3, 4, 5, 6, 7, 8, 9, 10, 13, 20, 23, 25, 27, 30, 40, 50, 60, 70, 80, 90,
                   100, 717, 784, 3796]:
        for class_n in classes:
            export_train_graph(model_class,
                               optimizers.AdamOptimizer,
                               1, linear, 1, class_n)


def export_image_classifier_model_graph(model_class):
    classes = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 100]
    height = [28, 32, 224, 299, 320]
    width = [28, 32, 224, 299, 320]
    channels = [1, 3]
    for (h, w) in zip(height, width):
        for ch in channels:
            for class_n in classes:
                export_train_graph(model_class,
                                   optimizers.AdamOptimizer,
                                   h, w, ch, class_n)


networks = {
    'mlp': mlp.MultiLayerPerceptron,
    'lenet': lenet.LeNet,
    'alexnet': alexnet.AlexNet,
    'vgg': vgg.VGG16,
    'inception': inception.InceptionV3,
    'resnet': resnet.ResNet
}


def parse_hidden_layers(hidden_string):
    return list(map(lambda x: int(x), hidden_string.replace('[', '').replace(']', '').split(',')))


if __name__ == "__main__":
    if len(sys.argv) > 1:
        model_class = networks[sys.argv[2]]
        if 'mlp' in sys.argv[2]:
            if len(sys.argv) == 8:
                hidden_layers = parse_hidden_layers(sys.argv[7])
            else:
                hidden_layers = [200, 200]
            model_class = partial(
                mlp.MultiLayerPerceptron,
                hidden_layers=hidden_layers
            )

        w = int(sys.argv[3])
        h = int(sys.argv[4])
        ch = int(sys.argv[5])
        class_n = int(sys.argv[6])

        export_train_graph(model_class,
                           optimizers.AdamOptimizer,
                           h, w, ch, class_n, sys.argv[1])
    else:
        # generate MLP
        default_mlp = partial(
            mlp.MultiLayerPerceptron,
            hidden_layers=[200, 200],  # FIXME
        )

        export_linear_model_graph(default_mlp)
        export_image_classifier_model_graph(default_mlp)

        # image models
        for model in (lenet.LeNet, alexnet.AlexNet, vgg.VGG16, inception.InceptionV3, resnet.ResNet):
            export_image_classifier_model_graph(model)
