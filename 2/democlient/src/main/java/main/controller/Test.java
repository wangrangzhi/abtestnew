package main.controller;

import main.ClientsidetestApplication;
import main.domain.soldproduct;
import main.feign.testbuy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController

public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    @RequestMapping("/call/{id}")
    public String callHome(@PathVariable String id) {
        logger.info("calling trace demo backend");
        return "hello" + id;
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/findAllClient/{id}")
    public List<String> findAllClient(@PathVariable String id) {
        List<ServiceInstance> list = discoveryClient.getInstances(id);
        List<String> returnList = null;
        if (list != null && list.size() > 0) {
            for (ServiceInstance sin : list) {
                String save = sin.getHost();
                StringBuffer savee = new StringBuffer(save);
                savee.append(":" + sin.getHost());
                returnList.add(savee.toString());

            }


        }
        return returnList;
    }


    @Value("${server.port}")
    String port;

    public volatile int numsave = 0;

    @RequestMapping("/port")
    public int callHome() {


                return 1;


    }

    @Autowired
    testbuy tb;

    private void startTheaction() {


        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {
            final int index = i;
            Runner1 myTask = new Runner1();
            fixedThreadPool.execute(myTask);
        }
        fixedThreadPool.shutdown();
    }

    private  String getTheRandnumber()
    {
        if(port == null || port.equals("0"))
        {
            return "I am random:" + new Integer( ((int)Math.random()*1000)).toString();
        }
        return port;
    }

    String aaa = getTheRandnumber();

    class Runner1 implements Runnable {


        // 实现了Runnable接口，jdk就知道这个类是一个线程
        public void run() {



            while(!Thread.currentThread().isInterrupted())
            {
               logger.info( Thread.currentThread().getName());
                soldproduct tbss = tb.callHome(ClientsidetestApplication.aaa,Thread.currentThread().getName());
                if(tbss == null )
                {
                    numsave = 1;
                    Thread.currentThread().interrupt();
                }else if( tbss.getId() == null)
                {
                    numsave = 1;
                    Thread.currentThread().interrupt();
                }
            }




        }
    }

}
