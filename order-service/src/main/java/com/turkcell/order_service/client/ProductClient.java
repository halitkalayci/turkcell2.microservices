package com.turkcell.order_service.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

// ProductService ile iletişime geçecek yardımcı classım
// Url varsa direkt url'den gider. Yoksa name ile service discoveryde bir eşleşme arar.
@FeignClient(name="product-service")
public interface ProductClient {
    @GetMapping("/api/v1/products")
    String get();
}
