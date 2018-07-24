package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
public class ClientsidetestApplication  {

	public static String aaa = "";

	public static void main(String[] args) {
		SpringApplication.run(ClientsidetestApplication.class, args);
		aaa = "I am random:" + new Integer( ((int)(Math.random()*1000))).toString();
	}



	private  String getTheRandnumber()
	{

			return "I am random:" + new Integer( ((int)(Math.random()*1000))).toString();

	}


}
