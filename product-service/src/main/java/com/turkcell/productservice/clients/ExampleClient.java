package com.turkcell.productservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "example-client", url = "https://google.com")
public interface ExampleClient {
    @GetMapping("/")
    Object get();
}
