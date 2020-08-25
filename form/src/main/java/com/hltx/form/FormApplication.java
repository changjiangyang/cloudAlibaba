package com.hltx.form;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.hltx.form.mapper")
public class FormApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormApplication.class, args);
    }

}
