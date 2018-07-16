package io.github.wangrangzhi.errukaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ErrukaserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErrukaserverApplication.class, args);
	}
}
