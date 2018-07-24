package java.io.github.wangrangzhi.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @RequestMapping("/findAllClient")
    public List<String> findAllClient() {
        List<ServiceInstance> list = discoveryClient.getInstances("theClient");
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

}
