package main;

import com.alibaba.druid.pool.DruidDataSource;
import main.utils.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.sql.DataSource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableSwagger2
@ServletComponentScan(value = "main.filter")
public class ServertestApplication   {
	public static ApplicationContext acon = null;

	public static void main(String[] args) {
		acon =SpringApplication.run(ServertestApplication.class, args);
		SpringUtil s = new SpringUtil();
				s.setApplicationContext(acon);

	}
	@Bean
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource druidDataSource() {
		return new DruidDataSource();
	}
}
