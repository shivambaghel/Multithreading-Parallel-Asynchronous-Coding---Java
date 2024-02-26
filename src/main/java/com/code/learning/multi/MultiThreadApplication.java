package com.code.learning.multi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication(scanBasePackages = {"com.code.learning.multi"})
@OpenAPIDefinition(info= @Info(title = "parallel Computing", version = "v1", description = "Learning- multiThreading/asynchronus processsing"))
public class MultiThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultiThreadApplication.class, args);
	}

}
