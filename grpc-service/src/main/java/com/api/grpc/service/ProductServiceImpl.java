package com.api.grpc.service;

import com.api.grpc.ProductRequest;
import com.api.grpc.ProductResponse;
import com.api.grpc.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {

    private final List<ProductResponse> products = List.of(
        ProductResponse.newBuilder().setId(1).setName("Laptop").setPrice(999.99).build(),
        ProductResponse.newBuilder().setId(2).setName("Mouse").setPrice(49.99).build(),
        ProductResponse.newBuilder().setId(3).setName("Keyboard").setPrice(79.99).build()
    );

    @Override
    public void getProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        ProductResponse resp = products.stream()
            .filter(p -> p.getId() == request.getId())
            .findFirst()
            .orElse(
              ProductResponse.newBuilder()
                .setId(0)
                .setName("NotFound")
                .setPrice(0.0)
                .build()
            );
        responseObserver.onNext(resp);
        responseObserver.onCompleted();
    }
}