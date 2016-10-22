package com.test.grpc.service;

import com.test.grpc.service.model.TestModel;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Created by xiaolezheng on 16/10/22.
 */
@Slf4j
public class TestServer {
    private int port = 50051;
    private Server server;

    public static void main(String[] args) throws Exception{
        TestServer testServer = new TestServer();
        testServer.start();
        testServer.blockUntilShutdown();
    }

    private void start() throws IOException {
        server = ServerBuilder.forPort(port)
                .addService(new TestServiceImpl())
                .build()
                .start();
        log.info("Server started, listening on " + port);
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                // Use stderr here since the logger may have been reset by its JVM shutdown hook.
                log.info("*** shutting down gRPC server since JVM is shutting down");
                TestServer.this.stop();
                log.info("*** server shut down");
            }
        });
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    /**
     * Await termination on the main thread since the grpc library uses daemon threads.
     */
    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    private class TestServiceImpl extends TestRpcServiceGrpc.TestRpcServiceImplBase {
        @Override
        public void sayHello(TestModel.TestRequest request, StreamObserver<TestModel.TestResponse> responseObserver) {
            TestModel.TestResponse response = TestModel.TestResponse.newBuilder().setMessage("hello " + request.getName()).build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
