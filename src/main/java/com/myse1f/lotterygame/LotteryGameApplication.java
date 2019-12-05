package com.myse1f.lotterygame;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

@SpringBootApplication
public class LotteryGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryGameApplication.class, args);
    }

    @Value("${web3j.http_service}")
    private String http_service;

    @Bean
    public Web3j web3j() {
        return Web3j.build(new HttpService(http_service));
    }
}
