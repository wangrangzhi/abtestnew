package main.controller;


import main.domain.soldproduct;
import main.mapper.soldproductMapper;
import main.service.soldservice;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoldPath {

    private static final Logger logger = LoggerFactory.getLogger(SoldPath.class);
    @Autowired
    private soldproductMapper sm;

    @Autowired
    private soldservice ss;




    @RequestMapping("/SoldPath/{port}/{threadname}")
    public soldproduct callHome(@PathVariable String port,@PathVariable String threadname ) {
        logger.info("calling trace demo backend");

        soldproduct a=  ss.soldTheproduct(port,threadname);



        return a;
    }
}
