package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "jwt", url = "http://localhost:8084")
public interface JWTFeignClient {

    @GetMapping("/validateToken")
    boolean validateToken(@RequestHeader("Authorization") String token);
}
