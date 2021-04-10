package com.awsdemo.functionaws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.cloud.function.context.FunctionalSpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

import java.util.function.Function;

@SpringBootApplication
//@SpringBootConfiguration
public class FunctionAwsApplication {

    public static void main(String[] args) {
        SpringApplication.run(FunctionAwsApplication.class, args);
       // FunctionalSpringApplication.run(FunctionAwsApplication.class, args);
    }

    @Bean
    public Function<String, String> reverseString() {
        return value -> value == null ? "BLANK_VALUE" : new StringBuilder(value).reverse().toString();
    }

   /* @Override
    public void initialize(GenericApplicationContext applicationContext) {
        applicationContext.registerBean("reverseString", FunctionRegistration.class,
                () -> new FunctionRegistration<>(reverseString())
                        .type(FunctionType.from(String.class).to(String.class)));
    }*/
}
