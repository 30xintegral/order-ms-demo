package com.example.ordermsdemo.feign;

import com.example.ordermsdemo.dto.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-client", url = "http://localhost:8082")
public interface ProductClient {
    @GetMapping("/getProdById/{id}")
    ProductResponse getProductById(@PathVariable Long id);

    @PatchMapping("/decreaseCount/{id}/{count}")
    void decreaseCountBy(@PathVariable Long id, @PathVariable int count);
}
