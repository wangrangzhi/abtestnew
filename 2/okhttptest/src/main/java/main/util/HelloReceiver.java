package main.util;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
    public static int a = 0;

    @RabbitHandler
    public void process(String hello) {

        System.out.println("Receiver  : " + hello);
        if(hello.equals("sold out"))
        {
            a=1;
        }
    }

}
