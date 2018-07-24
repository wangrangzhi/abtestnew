package io.github.wangrangzhi.demo.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import java.util.List;

@Configuration
@ImportResource(locations={"classpath:templates/application-mysql.xml"})
public class ConfigClass {



}