package main;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import main.util.HelloReceiver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = TestokhttpApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestokhttpApplicationTests {
    private static final Logger logger = LoggerFactory.getLogger(TestokhttpApplicationTests.class);
    @Test
	public void startTheaction() {


		ExecutorService executor = Executors.newFixedThreadPool(2);


		ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
		executor.execute(new Runner1());
		executor.execute(new Runner2());

		executor.shutdown();

	}


    OkHttpClient client = new OkHttpClient();

    public String runget(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        Response response = client.newCall(request).execute();
        String a= response.body().string();
        logger.info(a);
        return a;
    }


    @Test
    public void test01() throws IOException {

        runget("http://localhost:50368/port");
        //runget("http://localhost:52459/port");

        while(true)
        {
           if(HelloReceiver.a == 1)
           {
               logger.info("over");
           }
        }
    }

	class Runner1 implements Runnable  {
		public void run() {
		    try
            {
                runget("http://localhost:65093/port");
            }catch(IOException e)
            {
                e.printStackTrace();
            }

		}
    }

	class Runner2 implements Runnable {
		public void run() {
            try
            {
                runget("http://localhost:65107/port");
            }catch(IOException e)
            {
                e.printStackTrace();
            }
        }
	}

}

