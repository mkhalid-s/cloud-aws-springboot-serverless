package com.awsdemo.functionaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.function.Function;

@SpringBootApplication
public class FunctionAwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunctionAwsApplication.class, args);
    }

    @Bean
    public Function<String, String> reverseString() {
        return value -> value == null ? "BLANK_VALUE" : new StringBuilder(value).reverse().toString();
    }

}
