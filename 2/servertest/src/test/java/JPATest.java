import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import main.ServertestApplication;
import main.domain.soldproduct;
import main.repository.soldRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;

@SpringBootTest(classes = ServertestApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class JPATest {
    private static final Logger logger = LoggerFactory.getLogger(JPATest.class);

    @Resource
    private DataSource dataSource;
    @Autowired
    private soldRepository sRepository;
    @Test
    public void testConnection() throws Exception {
        System.out.println(this.dataSource);
        logger.info(
                sRepository.findAll().toString()
        );
    }
    @Test
    public void testInsertHunrend() throws Exception {
        soldproduct end = new soldproduct();
        end.setId(0);
        while(sRepository.count() < 300)
        {
            soldproduct s = sRepository.save(new soldproduct());
            logger.info(s.getId().toString());
            end = s;
        }
    }


}
