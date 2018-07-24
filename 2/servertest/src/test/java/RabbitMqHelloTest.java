import main.ServertestApplication;
import main.utils.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = ServertestApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class RabbitMqHelloTest {
    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {

          helloSender.send();



    }
}
