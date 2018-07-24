package java.io.github.wangrangzhi.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.github.wangrangzhi.demo.domain.soldproduct;
import java.io.github.wangrangzhi.demo.mapper.soldproductMapper;

public class Sold {

    private static final Logger logger = LoggerFactory.getLogger(Sold.class);
    private soldproductMapper sproductMapper;



    @RequestMapping("/sold/{port}")
    public String callHome(@PathVariable String port) {
        logger.info("calling trace demo backend");

        soldproduct record = new soldproduct();
        record.setName("sd");
        sproductMapper.insert( record);



        return "hello" + port;
    }
}
