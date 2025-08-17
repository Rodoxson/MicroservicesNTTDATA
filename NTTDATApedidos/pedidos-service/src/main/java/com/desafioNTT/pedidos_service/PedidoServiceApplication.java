package com.desafioNTT.pedidos_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
// @EnableEurekaClient // Removed, not needed


public class PedidoServiceApplication {

    @Bean
    @LoadBalanced
        public RestTemplate restTemplate() {
            return new RestTemplate();
}

    public static void main(String[] args) {
        SpringApplication.run(PedidoServiceApplication.class, args);
    }
}
