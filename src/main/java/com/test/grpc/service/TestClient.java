package com.test.grpc.service;

import com.test.grpc.service.model.TestModel;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * Created by xiaolezheng on 16/10/22.
 */
@Slf4j
public class TestClient {

    private final ManagedChannel channel;
    private final TestRpcServiceGrpc.TestRpcServiceBlockingStub blockingStub;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public TestClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext(true)
                .build();
        blockingStub = TestRpcServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    /** Say hello to server. */
    public void greet(String name) {
        log.info("Will try to greet " + name + " ...");
        TestModel.TestRequest request = TestModel.TestRequest.newBuilder().setName(name).build();
        try {
            TestModel.TestResponse response = blockingStub.sayHello(request);
            log.info("Greeting: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            log.error("RPC failed: {0}", e.getStatus());
            return;
        }

    }

    /**
     * Greet server. If provided, the first element of {@code args} is the name to use in the
     * greeting.
     */
    public static void main(String[] args) throws Exception {
        TestClient client = new TestClient("localhost", 50051);
        try {
            for(int i=0; i<10; i++) {
                client.greet("jim->"+i);
            }
        } finally {
            client.shutdown();
        }
    }
}
