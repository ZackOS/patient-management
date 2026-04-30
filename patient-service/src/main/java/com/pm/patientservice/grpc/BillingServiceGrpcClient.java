package com.pm.patientservice.grpc;

import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import net.devh.boot.grpc.client.stubfactory.BlockingStubFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceGrpcClient {

    static final Logger log = LoggerFactory.getLogger(BillingServiceGrpcClient.class);
    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;
    private final BlockingStubFactory blockingStubFactory;

    //localhost:9001/BillingService/CreatePatientAccount
    //aws.grpc:123123/BillingService/CreatePatientAccount

    public BillingServiceGrpcClient(
            @Value("${billing.service.address:localhost}") String serverAddress,
            @Value("${billing.service.grpc.port:9001}") int serverPort,
            BlockingStubFactory blockingStubFactory) {
        log.info("Connecting to Billing Service GRPC service at {}:{}", serverAddress, serverPort);

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAddress,
                serverPort).usePlaintext().build();

        blockingStub = BillingServiceGrpc.newBlockingStub(channel);
        this.blockingStubFactory = blockingStubFactory;
    }

    public BillingResponse createBillingAccount(String patientId, String name,
                                                String email) {
        BillingRequest request = BillingRequest.newBuilder().setPatientId(patientId)
                .setName(name).setEmail(email).build();

        BillingResponse response = blockingStub.createBillingAccount(request);
        log.info("Received Response from billing service via GRPC: {}", response);

        return response;
    }
}
