package java.io.github.wangrangzhi.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:templates/application-mysql.xml"})
public class ConfigClass {



}