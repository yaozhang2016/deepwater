// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: tensorflow/core/protobuf/config.proto

package org.tensorflow.framework;

/**
 * <pre>
 * EXPERIMENTAL. Option for watching a node.
 * </pre>
 *
 * Protobuf type {@code tensorflow.DebugTensorWatch}
 */
public  final class DebugTensorWatch extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:tensorflow.DebugTensorWatch)
    DebugTensorWatchOrBuilder {
  // Use DebugTensorWatch.newBuilder() to construct.
  private DebugTensorWatch(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private DebugTensorWatch() {
    nodeName_ = "";
    outputSlot_ = 0;
    debugOps_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    debugUrls_ = com.google.protobuf.LazyStringArrayList.EMPTY;
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
  }
  private DebugTensorWatch(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    int mutable_bitField0_ = 0;
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!input.skipField(tag)) {
              done = true;
            }
            break;
          }
          case 10: {
            java.lang.String s = input.readStringRequireUtf8();

            nodeName_ = s;
            break;
          }
          case 16: {

            outputSlot_ = input.readInt32();
            break;
          }
          case 26: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              debugOps_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000004;
            }
            debugOps_.add(s);
            break;
          }
          case 34: {
            java.lang.String s = input.readStringRequireUtf8();
            if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
              debugUrls_ = new com.google.protobuf.LazyStringArrayList();
              mutable_bitField0_ |= 0x00000008;
            }
            debugUrls_.add(s);
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        debugOps_ = debugOps_.getUnmodifiableView();
      }
      if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
        debugUrls_ = debugUrls_.getUnmodifiableView();
      }
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return org.tensorflow.framework.ConfigProtos.internal_static_tensorflow_DebugTensorWatch_descriptor;
  }

  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return org.tensorflow.framework.ConfigProtos.internal_static_tensorflow_DebugTensorWatch_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            org.tensorflow.framework.DebugTensorWatch.class, org.tensorflow.framework.DebugTensorWatch.Builder.class);
  }

  private int bitField0_;
  public static final int NODE_NAME_FIELD_NUMBER = 1;
  private volatile java.lang.Object nodeName_;
  /**
   * <pre>
   * Name of the node to watch.
   * </pre>
   *
   * <code>optional string node_name = 1;</code>
   */
  public java.lang.String getNodeName() {
    java.lang.Object ref = nodeName_;
    if (ref instanceof java.lang.String) {
      return (java.lang.String) ref;
    } else {
      com.google.protobuf.ByteString bs = 
          (com.google.protobuf.ByteString) ref;
      java.lang.String s = bs.toStringUtf8();
      nodeName_ = s;
      return s;
    }
  }
  /**
   * <pre>
   * Name of the node to watch.
   * </pre>
   *
   * <code>optional string node_name = 1;</code>
   */
  public com.google.protobuf.ByteString
      getNodeNameBytes() {
    java.lang.Object ref = nodeName_;
    if (ref instanceof java.lang.String) {
      com.google.protobuf.ByteString b = 
          com.google.protobuf.ByteString.copyFromUtf8(
              (java.lang.String) ref);
      nodeName_ = b;
      return b;
    } else {
      return (com.google.protobuf.ByteString) ref;
    }
  }

  public static final int OUTPUT_SLOT_FIELD_NUMBER = 2;
  private int outputSlot_;
  /**
   * <pre>
   * Output slot to watch.
   * The semantics of output_slot == -1 is that the node is only watched for
   * completion, but not for any output tensors. See NodeCompletionCallback
   * in debug_gateway.h.
   * TODO(cais): Implement this semantics.
   * </pre>
   *
   * <code>optional int32 output_slot = 2;</code>
   */
  public int getOutputSlot() {
    return outputSlot_;
  }

  public static final int DEBUG_OPS_FIELD_NUMBER = 3;
  private com.google.protobuf.LazyStringList debugOps_;
  /**
   * <pre>
   * Name(s) of the debugging op(s).
   * One or more than one probes on a tensor.
   * e.g., {"DebugIdentity", "DebugNanCount"}
   * </pre>
   *
   * <code>repeated string debug_ops = 3;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getDebugOpsList() {
    return debugOps_;
  }
  /**
   * <pre>
   * Name(s) of the debugging op(s).
   * One or more than one probes on a tensor.
   * e.g., {"DebugIdentity", "DebugNanCount"}
   * </pre>
   *
   * <code>repeated string debug_ops = 3;</code>
   */
  public int getDebugOpsCount() {
    return debugOps_.size();
  }
  /**
   * <pre>
   * Name(s) of the debugging op(s).
   * One or more than one probes on a tensor.
   * e.g., {"DebugIdentity", "DebugNanCount"}
   * </pre>
   *
   * <code>repeated string debug_ops = 3;</code>
   */
  public java.lang.String getDebugOps(int index) {
    return debugOps_.get(index);
  }
  /**
   * <pre>
   * Name(s) of the debugging op(s).
   * One or more than one probes on a tensor.
   * e.g., {"DebugIdentity", "DebugNanCount"}
   * </pre>
   *
   * <code>repeated string debug_ops = 3;</code>
   */
  public com.google.protobuf.ByteString
      getDebugOpsBytes(int index) {
    return debugOps_.getByteString(index);
  }

  public static final int DEBUG_URLS_FIELD_NUMBER = 4;
  private com.google.protobuf.LazyStringList debugUrls_;
  /**
   * <pre>
   * URL(s) for debug targets(s).
   *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
   * Each debug op listed in debug_ops will publish its output tensor (debug
   * signal) to all URLs in debug_urls.
   * </pre>
   *
   * <code>repeated string debug_urls = 4;</code>
   */
  public com.google.protobuf.ProtocolStringList
      getDebugUrlsList() {
    return debugUrls_;
  }
  /**
   * <pre>
   * URL(s) for debug targets(s).
   *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
   * Each debug op listed in debug_ops will publish its output tensor (debug
   * signal) to all URLs in debug_urls.
   * </pre>
   *
   * <code>repeated string debug_urls = 4;</code>
   */
  public int getDebugUrlsCount() {
    return debugUrls_.size();
  }
  /**
   * <pre>
   * URL(s) for debug targets(s).
   *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
   * Each debug op listed in debug_ops will publish its output tensor (debug
   * signal) to all URLs in debug_urls.
   * </pre>
   *
   * <code>repeated string debug_urls = 4;</code>
   */
  public java.lang.String getDebugUrls(int index) {
    return debugUrls_.get(index);
  }
  /**
   * <pre>
   * URL(s) for debug targets(s).
   *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
   * Each debug op listed in debug_ops will publish its output tensor (debug
   * signal) to all URLs in debug_urls.
   * </pre>
   *
   * <code>repeated string debug_urls = 4;</code>
   */
  public com.google.protobuf.ByteString
      getDebugUrlsBytes(int index) {
    return debugUrls_.getByteString(index);
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!getNodeNameBytes().isEmpty()) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 1, nodeName_);
    }
    if (outputSlot_ != 0) {
      output.writeInt32(2, outputSlot_);
    }
    for (int i = 0; i < debugOps_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 3, debugOps_.getRaw(i));
    }
    for (int i = 0; i < debugUrls_.size(); i++) {
      com.google.protobuf.GeneratedMessageV3.writeString(output, 4, debugUrls_.getRaw(i));
    }
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!getNodeNameBytes().isEmpty()) {
      size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, nodeName_);
    }
    if (outputSlot_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, outputSlot_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < debugOps_.size(); i++) {
        dataSize += computeStringSizeNoTag(debugOps_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getDebugOpsList().size();
    }
    {
      int dataSize = 0;
      for (int i = 0; i < debugUrls_.size(); i++) {
        dataSize += computeStringSizeNoTag(debugUrls_.getRaw(i));
      }
      size += dataSize;
      size += 1 * getDebugUrlsList().size();
    }
    memoizedSize = size;
    return size;
  }

  private static final long serialVersionUID = 0L;
  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof org.tensorflow.framework.DebugTensorWatch)) {
      return super.equals(obj);
    }
    org.tensorflow.framework.DebugTensorWatch other = (org.tensorflow.framework.DebugTensorWatch) obj;

    boolean result = true;
    result = result && getNodeName()
        .equals(other.getNodeName());
    result = result && (getOutputSlot()
        == other.getOutputSlot());
    result = result && getDebugOpsList()
        .equals(other.getDebugOpsList());
    result = result && getDebugUrlsList()
        .equals(other.getDebugUrlsList());
    return result;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptorForType().hashCode();
    hash = (37 * hash) + NODE_NAME_FIELD_NUMBER;
    hash = (53 * hash) + getNodeName().hashCode();
    hash = (37 * hash) + OUTPUT_SLOT_FIELD_NUMBER;
    hash = (53 * hash) + getOutputSlot();
    if (getDebugOpsCount() > 0) {
      hash = (37 * hash) + DEBUG_OPS_FIELD_NUMBER;
      hash = (53 * hash) + getDebugOpsList().hashCode();
    }
    if (getDebugUrlsCount() > 0) {
      hash = (37 * hash) + DEBUG_URLS_FIELD_NUMBER;
      hash = (53 * hash) + getDebugUrlsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static org.tensorflow.framework.DebugTensorWatch parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.DebugTensorWatch parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.DebugTensorWatch parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static org.tensorflow.framework.DebugTensorWatch parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static org.tensorflow.framework.DebugTensorWatch parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.DebugTensorWatch parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.framework.DebugTensorWatch parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.DebugTensorWatch parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static org.tensorflow.framework.DebugTensorWatch parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static org.tensorflow.framework.DebugTensorWatch parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(org.tensorflow.framework.DebugTensorWatch prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * EXPERIMENTAL. Option for watching a node.
   * </pre>
   *
   * Protobuf type {@code tensorflow.DebugTensorWatch}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:tensorflow.DebugTensorWatch)
      org.tensorflow.framework.DebugTensorWatchOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return org.tensorflow.framework.ConfigProtos.internal_static_tensorflow_DebugTensorWatch_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return org.tensorflow.framework.ConfigProtos.internal_static_tensorflow_DebugTensorWatch_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              org.tensorflow.framework.DebugTensorWatch.class, org.tensorflow.framework.DebugTensorWatch.Builder.class);
    }

    // Construct using org.tensorflow.framework.DebugTensorWatch.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      nodeName_ = "";

      outputSlot_ = 0;

      debugOps_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      debugUrls_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return org.tensorflow.framework.ConfigProtos.internal_static_tensorflow_DebugTensorWatch_descriptor;
    }

    public org.tensorflow.framework.DebugTensorWatch getDefaultInstanceForType() {
      return org.tensorflow.framework.DebugTensorWatch.getDefaultInstance();
    }

    public org.tensorflow.framework.DebugTensorWatch build() {
      org.tensorflow.framework.DebugTensorWatch result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public org.tensorflow.framework.DebugTensorWatch buildPartial() {
      org.tensorflow.framework.DebugTensorWatch result = new org.tensorflow.framework.DebugTensorWatch(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.nodeName_ = nodeName_;
      result.outputSlot_ = outputSlot_;
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        debugOps_ = debugOps_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000004);
      }
      result.debugOps_ = debugOps_;
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        debugUrls_ = debugUrls_.getUnmodifiableView();
        bitField0_ = (bitField0_ & ~0x00000008);
      }
      result.debugUrls_ = debugUrls_;
      result.bitField0_ = to_bitField0_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof org.tensorflow.framework.DebugTensorWatch) {
        return mergeFrom((org.tensorflow.framework.DebugTensorWatch)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(org.tensorflow.framework.DebugTensorWatch other) {
      if (other == org.tensorflow.framework.DebugTensorWatch.getDefaultInstance()) return this;
      if (!other.getNodeName().isEmpty()) {
        nodeName_ = other.nodeName_;
        onChanged();
      }
      if (other.getOutputSlot() != 0) {
        setOutputSlot(other.getOutputSlot());
      }
      if (!other.debugOps_.isEmpty()) {
        if (debugOps_.isEmpty()) {
          debugOps_ = other.debugOps_;
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          ensureDebugOpsIsMutable();
          debugOps_.addAll(other.debugOps_);
        }
        onChanged();
      }
      if (!other.debugUrls_.isEmpty()) {
        if (debugUrls_.isEmpty()) {
          debugUrls_ = other.debugUrls_;
          bitField0_ = (bitField0_ & ~0x00000008);
        } else {
          ensureDebugUrlsIsMutable();
          debugUrls_.addAll(other.debugUrls_);
        }
        onChanged();
      }
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      org.tensorflow.framework.DebugTensorWatch parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (org.tensorflow.framework.DebugTensorWatch) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.lang.Object nodeName_ = "";
    /**
     * <pre>
     * Name of the node to watch.
     * </pre>
     *
     * <code>optional string node_name = 1;</code>
     */
    public java.lang.String getNodeName() {
      java.lang.Object ref = nodeName_;
      if (!(ref instanceof java.lang.String)) {
        com.google.protobuf.ByteString bs =
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        nodeName_ = s;
        return s;
      } else {
        return (java.lang.String) ref;
      }
    }
    /**
     * <pre>
     * Name of the node to watch.
     * </pre>
     *
     * <code>optional string node_name = 1;</code>
     */
    public com.google.protobuf.ByteString
        getNodeNameBytes() {
      java.lang.Object ref = nodeName_;
      if (ref instanceof String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        nodeName_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }
    /**
     * <pre>
     * Name of the node to watch.
     * </pre>
     *
     * <code>optional string node_name = 1;</code>
     */
    public Builder setNodeName(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      nodeName_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Name of the node to watch.
     * </pre>
     *
     * <code>optional string node_name = 1;</code>
     */
    public Builder clearNodeName() {
      
      nodeName_ = getDefaultInstance().getNodeName();
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Name of the node to watch.
     * </pre>
     *
     * <code>optional string node_name = 1;</code>
     */
    public Builder setNodeNameBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      
      nodeName_ = value;
      onChanged();
      return this;
    }

    private int outputSlot_ ;
    /**
     * <pre>
     * Output slot to watch.
     * The semantics of output_slot == -1 is that the node is only watched for
     * completion, but not for any output tensors. See NodeCompletionCallback
     * in debug_gateway.h.
     * TODO(cais): Implement this semantics.
     * </pre>
     *
     * <code>optional int32 output_slot = 2;</code>
     */
    public int getOutputSlot() {
      return outputSlot_;
    }
    /**
     * <pre>
     * Output slot to watch.
     * The semantics of output_slot == -1 is that the node is only watched for
     * completion, but not for any output tensors. See NodeCompletionCallback
     * in debug_gateway.h.
     * TODO(cais): Implement this semantics.
     * </pre>
     *
     * <code>optional int32 output_slot = 2;</code>
     */
    public Builder setOutputSlot(int value) {
      
      outputSlot_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Output slot to watch.
     * The semantics of output_slot == -1 is that the node is only watched for
     * completion, but not for any output tensors. See NodeCompletionCallback
     * in debug_gateway.h.
     * TODO(cais): Implement this semantics.
     * </pre>
     *
     * <code>optional int32 output_slot = 2;</code>
     */
    public Builder clearOutputSlot() {
      
      outputSlot_ = 0;
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList debugOps_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureDebugOpsIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        debugOps_ = new com.google.protobuf.LazyStringArrayList(debugOps_);
        bitField0_ |= 0x00000004;
       }
    }
    /**
     * <pre>
     * Name(s) of the debugging op(s).
     * One or more than one probes on a tensor.
     * e.g., {"DebugIdentity", "DebugNanCount"}
     * </pre>
     *
     * <code>repeated string debug_ops = 3;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getDebugOpsList() {
      return debugOps_.getUnmodifiableView();
    }
    /**
     * <pre>
     * Name(s) of the debugging op(s).
     * One or more than one probes on a tensor.
     * e.g., {"DebugIdentity", "DebugNanCount"}
     * </pre>
     *
     * <code>repeated string debug_ops = 3;</code>
     */
    public int getDebugOpsCount() {
      return debugOps_.size();
    }
    /**
     * <pre>
     * Name(s) of the debugging op(s).
     * One or more than one probes on a tensor.
     * e.g., {"DebugIdentity", "DebugNanCount"}
     * </pre>
     *
     * <code>repeated string debug_ops = 3;</code>
     */
    public java.lang.String getDebugOps(int index) {
      return debugOps_.get(index);
    }
    /**
     * <pre>
     * Name(s) of the debugging op(s).
     * One or more than one probes on a tensor.
     * e.g., {"DebugIdentity", "DebugNanCount"}
     * </pre>
     *
     * <code>repeated string debug_ops = 3;</code>
     */
    public com.google.protobuf.ByteString
        getDebugOpsBytes(int index) {
      return debugOps_.getByteString(index);
    }
    /**
     * <pre>
     * Name(s) of the debugging op(s).
     * One or more than one probes on a tensor.
     * e.g., {"DebugIdentity", "DebugNanCount"}
     * </pre>
     *
     * <code>repeated string debug_ops = 3;</code>
     */
    public Builder setDebugOps(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureDebugOpsIsMutable();
      debugOps_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Name(s) of the debugging op(s).
     * One or more than one probes on a tensor.
     * e.g., {"DebugIdentity", "DebugNanCount"}
     * </pre>
     *
     * <code>repeated string debug_ops = 3;</code>
     */
    public Builder addDebugOps(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureDebugOpsIsMutable();
      debugOps_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Name(s) of the debugging op(s).
     * One or more than one probes on a tensor.
     * e.g., {"DebugIdentity", "DebugNanCount"}
     * </pre>
     *
     * <code>repeated string debug_ops = 3;</code>
     */
    public Builder addAllDebugOps(
        java.lang.Iterable<java.lang.String> values) {
      ensureDebugOpsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, debugOps_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Name(s) of the debugging op(s).
     * One or more than one probes on a tensor.
     * e.g., {"DebugIdentity", "DebugNanCount"}
     * </pre>
     *
     * <code>repeated string debug_ops = 3;</code>
     */
    public Builder clearDebugOps() {
      debugOps_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * Name(s) of the debugging op(s).
     * One or more than one probes on a tensor.
     * e.g., {"DebugIdentity", "DebugNanCount"}
     * </pre>
     *
     * <code>repeated string debug_ops = 3;</code>
     */
    public Builder addDebugOpsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureDebugOpsIsMutable();
      debugOps_.add(value);
      onChanged();
      return this;
    }

    private com.google.protobuf.LazyStringList debugUrls_ = com.google.protobuf.LazyStringArrayList.EMPTY;
    private void ensureDebugUrlsIsMutable() {
      if (!((bitField0_ & 0x00000008) == 0x00000008)) {
        debugUrls_ = new com.google.protobuf.LazyStringArrayList(debugUrls_);
        bitField0_ |= 0x00000008;
       }
    }
    /**
     * <pre>
     * URL(s) for debug targets(s).
     *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
     * Each debug op listed in debug_ops will publish its output tensor (debug
     * signal) to all URLs in debug_urls.
     * </pre>
     *
     * <code>repeated string debug_urls = 4;</code>
     */
    public com.google.protobuf.ProtocolStringList
        getDebugUrlsList() {
      return debugUrls_.getUnmodifiableView();
    }
    /**
     * <pre>
     * URL(s) for debug targets(s).
     *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
     * Each debug op listed in debug_ops will publish its output tensor (debug
     * signal) to all URLs in debug_urls.
     * </pre>
     *
     * <code>repeated string debug_urls = 4;</code>
     */
    public int getDebugUrlsCount() {
      return debugUrls_.size();
    }
    /**
     * <pre>
     * URL(s) for debug targets(s).
     *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
     * Each debug op listed in debug_ops will publish its output tensor (debug
     * signal) to all URLs in debug_urls.
     * </pre>
     *
     * <code>repeated string debug_urls = 4;</code>
     */
    public java.lang.String getDebugUrls(int index) {
      return debugUrls_.get(index);
    }
    /**
     * <pre>
     * URL(s) for debug targets(s).
     *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
     * Each debug op listed in debug_ops will publish its output tensor (debug
     * signal) to all URLs in debug_urls.
     * </pre>
     *
     * <code>repeated string debug_urls = 4;</code>
     */
    public com.google.protobuf.ByteString
        getDebugUrlsBytes(int index) {
      return debugUrls_.getByteString(index);
    }
    /**
     * <pre>
     * URL(s) for debug targets(s).
     *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
     * Each debug op listed in debug_ops will publish its output tensor (debug
     * signal) to all URLs in debug_urls.
     * </pre>
     *
     * <code>repeated string debug_urls = 4;</code>
     */
    public Builder setDebugUrls(
        int index, java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureDebugUrlsIsMutable();
      debugUrls_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * URL(s) for debug targets(s).
     *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
     * Each debug op listed in debug_ops will publish its output tensor (debug
     * signal) to all URLs in debug_urls.
     * </pre>
     *
     * <code>repeated string debug_urls = 4;</code>
     */
    public Builder addDebugUrls(
        java.lang.String value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureDebugUrlsIsMutable();
      debugUrls_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * URL(s) for debug targets(s).
     *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
     * Each debug op listed in debug_ops will publish its output tensor (debug
     * signal) to all URLs in debug_urls.
     * </pre>
     *
     * <code>repeated string debug_urls = 4;</code>
     */
    public Builder addAllDebugUrls(
        java.lang.Iterable<java.lang.String> values) {
      ensureDebugUrlsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, debugUrls_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * URL(s) for debug targets(s).
     *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
     * Each debug op listed in debug_ops will publish its output tensor (debug
     * signal) to all URLs in debug_urls.
     * </pre>
     *
     * <code>repeated string debug_urls = 4;</code>
     */
    public Builder clearDebugUrls() {
      debugUrls_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      bitField0_ = (bitField0_ & ~0x00000008);
      onChanged();
      return this;
    }
    /**
     * <pre>
     * URL(s) for debug targets(s).
     *   E.g., "file:///foo/tfdbg_dump", "grpc://localhost:11011"
     * Each debug op listed in debug_ops will publish its output tensor (debug
     * signal) to all URLs in debug_urls.
     * </pre>
     *
     * <code>repeated string debug_urls = 4;</code>
     */
    public Builder addDebugUrlsBytes(
        com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
      ensureDebugUrlsIsMutable();
      debugUrls_.add(value);
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return this;
    }


    // @@protoc_insertion_point(builder_scope:tensorflow.DebugTensorWatch)
  }

  // @@protoc_insertion_point(class_scope:tensorflow.DebugTensorWatch)
  private static final org.tensorflow.framework.DebugTensorWatch DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new org.tensorflow.framework.DebugTensorWatch();
  }

  public static org.tensorflow.framework.DebugTensorWatch getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<DebugTensorWatch>
      PARSER = new com.google.protobuf.AbstractParser<DebugTensorWatch>() {
    public DebugTensorWatch parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
        return new DebugTensorWatch(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<DebugTensorWatch> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<DebugTensorWatch> getParserForType() {
    return PARSER;
  }

  public org.tensorflow.framework.DebugTensorWatch getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}
