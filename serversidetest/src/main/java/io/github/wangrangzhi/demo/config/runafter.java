package io.github.wangrangzhi.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@Component
@Order(value = 1)
public class runafter implements ApplicationRunner {
    //@Qualifier("dataSource")
    @Autowired
    DataSource ds;


    @Override
    public void run(ApplicationArguments var1) throws Exception{
        System.out.println("MyApplicationRunner1!");
        testBoneCP();
    }


    public void testBoneCP() throws SQLException {
        Connection connection = ds.getConnection();
        System.out.println(connection); // do something with the connection here..
    }
}
