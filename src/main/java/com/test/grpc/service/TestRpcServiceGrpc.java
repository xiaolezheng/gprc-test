package com.test.grpc.service;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.0.1)",
    comments = "Source: TestService.proto")
public class TestRpcServiceGrpc {

  private TestRpcServiceGrpc() {}

  public static final String SERVICE_NAME = "com.test.grpc.TestRpcService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.test.grpc.service.model.TestModel.TestRequest,
      com.test.grpc.service.model.TestModel.TestResponse> METHOD_SAY_HELLO =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.test.grpc.TestRpcService", "sayHello"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.test.grpc.service.model.TestModel.TestRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.test.grpc.service.model.TestModel.TestResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TestRpcServiceStub newStub(io.grpc.Channel channel) {
    return new TestRpcServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TestRpcServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new TestRpcServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static TestRpcServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new TestRpcServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class TestRpcServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(com.test.grpc.service.model.TestModel.TestRequest request,
        io.grpc.stub.StreamObserver<com.test.grpc.service.model.TestModel.TestResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_SAY_HELLO, responseObserver);
    }

    @Override public io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_SAY_HELLO,
            asyncUnaryCall(
              new MethodHandlers<
                com.test.grpc.service.model.TestModel.TestRequest,
                com.test.grpc.service.model.TestModel.TestResponse>(
                  this, METHODID_SAY_HELLO)))
          .build();
    }
  }

  /**
   */
  public static final class TestRpcServiceStub extends io.grpc.stub.AbstractStub<TestRpcServiceStub> {
    private TestRpcServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestRpcServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TestRpcServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestRpcServiceStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(com.test.grpc.service.model.TestModel.TestRequest request,
        io.grpc.stub.StreamObserver<com.test.grpc.service.model.TestModel.TestResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_SAY_HELLO, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class TestRpcServiceBlockingStub extends io.grpc.stub.AbstractStub<TestRpcServiceBlockingStub> {
    private TestRpcServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestRpcServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TestRpcServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestRpcServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.test.grpc.service.model.TestModel.TestResponse sayHello(com.test.grpc.service.model.TestModel.TestRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_SAY_HELLO, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class TestRpcServiceFutureStub extends io.grpc.stub.AbstractStub<TestRpcServiceFutureStub> {
    private TestRpcServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private TestRpcServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected TestRpcServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new TestRpcServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.test.grpc.service.model.TestModel.TestResponse> sayHello(
        com.test.grpc.service.model.TestModel.TestRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_SAY_HELLO, getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

  private static class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final TestRpcServiceImplBase serviceImpl;
    private final int methodId;

    public MethodHandlers(TestRpcServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.test.grpc.service.model.TestModel.TestRequest) request,
              (io.grpc.stub.StreamObserver<com.test.grpc.service.model.TestModel.TestResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    return new io.grpc.ServiceDescriptor(SERVICE_NAME,
        METHOD_SAY_HELLO);
  }

}