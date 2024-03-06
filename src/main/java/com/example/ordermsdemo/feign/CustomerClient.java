package com.example.ordermsdemo.feign;

import com.example.ordermsdemo.dto.response.CustomerResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@FeignClient(name = "customer-client", url = "http://localhost:8081")
public interface CustomerClient {

    @GetMapping("/getCustomer/{id}")
    ResponseEntity<CustomerResponse> getCustomer(@PathVariable Long id);

    @PatchMapping("/decreaseBalance/{id}/{amount}")
    void decreaseBalanceBy(@PathVariable Long id, @PathVariable double amount);

    @PatchMapping("/increaseBalance/{id}/{amount}")
    void increaseBalanceBy(@PathVariable Long id, @PathVariable double amount);


}
