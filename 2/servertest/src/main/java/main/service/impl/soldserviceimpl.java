package main.service.impl;

import main.domain.soldproduct;
import main.mapper.soldproductMapper;
import main.service.soldservice;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

@Service("soldservice")
public class soldserviceimpl implements soldservice {
    @Resource
    private soldproductMapper sproductMapper;
    @Override
    public int insert(soldproduct record) {
        return this.sproductMapper.insert(record);
    }
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Override
    @Transactional
    public soldproduct soldTheproduct(String port,String threadname) {

        soldproduct sss= sproductMapper.selectPortNotNull();
        if(sss != null)
        {
            sss.setPortbuy(port);
            sss.setName(threadname);
            sproductMapper.updateByPrimaryKey(sss);
            return sss;
        }
        else
        {
            this.rabbitTemplate.convertAndSend("hello", "sold out");
            soldproduct nullss = new soldproduct();
             return nullss;
        }

    }
}
