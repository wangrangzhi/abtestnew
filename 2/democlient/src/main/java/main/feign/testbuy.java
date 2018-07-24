package main.feign;

import main.domain.soldproduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("serversidetest")
public interface testbuy {
    @RequestMapping(value = "/SoldPath/{port}/{threadname}", method = RequestMethod.GET)
    public soldproduct callHome(@PathVariable("port") String port,@PathVariable("threadname") String threadname );
}
