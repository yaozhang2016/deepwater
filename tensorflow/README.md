# TensorFlow Bindings for H2O.ai

This package provides inference bindings for Tensorflow and H2O.ai.
The module directory contains a pretrained set of ready to use models. 


## Prerequisites

  - bazel
  - swig
  - python
  - maven

### Install Bazel 0.4.5 or later
For Linux:

```bash
wget https://github.com/bazelbuild/bazel/releases/download/0.4.5/bazel-0.4.5-installer-linux-x86_64.sh
sudo bash bazel-0.4.5-installer-linux-x86_64.sh
exit
```

### Install SWIG
For Linux:
```
sudo apt-get install swig
```

For Mac:
```
brew install swig
```

### Install Maven
For Linux:
```
sudo apt install maven
```

For Mac:
```
brew install maven
```

## Build the Tensorflow native java library and the Tensorflow H2O bindings
From the main project directory run `./gradlew clean tensorflowCompile` to build the `so` and `jar` TensorFlow files. This can take several minutes.

Go back to the top-level directory of the deepwater repo, and follow the directions there.
