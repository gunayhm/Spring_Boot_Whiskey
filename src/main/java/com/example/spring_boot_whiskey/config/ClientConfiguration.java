package com.example.spring_boot_whiskey.config;

import com.example.spring_boot_whiskey.client.ProductClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(clients = {ProductClient.class})
public class ClientConfiguration {
}