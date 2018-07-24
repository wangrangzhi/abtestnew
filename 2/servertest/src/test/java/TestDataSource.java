


import javax.annotation.Resource;
import javax.sql.DataSource;

import main.ServertestApplication;
import main.domain.soldproduct;
import main.mapper.soldproductMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest(classes = ServertestApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration

public class TestDataSource implements ApplicationContextAware {
    private static final Logger logger = LoggerFactory.getLogger(TestDataSource.class);
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Resource
    private DataSource dataSource;
    @Test
    public void testConnection() throws Exception {
        System.out.println(this.dataSource);
    }


    @Test
    public void testList() throws Exception {
     //   sold s = (sold) applicationContext.getBean("soldPath");
//        solddf.insert(new soldproduct());
    //   System.out.println( s.insert(new soldproduct()));
    }

    @Autowired
    private soldproductMapper sm;
    @Test
    public void testsoldproductMapper() throws Exception {
        logger.info( sm.selectByPrimaryKey(2).toString());
    }

}