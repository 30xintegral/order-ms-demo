package com.example.ordermsdemo;

import com.example.ordermsdemo.feign.CustomerClient;
import com.example.ordermsdemo.feign.ProductClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {
        CustomerClient.class,
        ProductClient.class
})
public class OrderMsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderMsDemoApplication.class, args);
    }

}
