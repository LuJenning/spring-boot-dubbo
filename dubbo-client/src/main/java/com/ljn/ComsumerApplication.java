package com.ljn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource(locations = {"classpath:spring-dubbo-consumer.xml"})
@SpringBootApplication
public class ComsumerApplication {
    public static void main(String[] args){
        SpringApplication.run(ComsumerApplication.class,args);
        System.out.println("===========Client Start !=============");

    }
}
