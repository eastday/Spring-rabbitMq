package com.eastday.service.impl;

import com.eastday.BaseTester;
import com.eastday.service.IProductService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ProductServiceImplTest extends BaseTester {

    @Autowired
    private IProductService productService;

    @Test
    public void sendDataToQueue() {

        //direct-exchange
        for(int i=0;i<2;i++) {
            //如不指定exchange 则使用template 默认配置的exchange
            productService.sendDataToQueue("order", "testestsetest"+System.currentTimeMillis());

            productService.sendDataToExchange("directexchange","orderDirect", "orderDirect"+System.currentTimeMillis());
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void sendDataToExchange() {

        // topic-exchange
        //第二个参数为路由key(routingKey)的值，
        // 当路由可以为ed.mail 时，(activity,mail)两个消费队列都可以收到消息，
        // 当值为ed.car，(car,activity)两个消费队列都可以收到消息，
        // 当值为t.car ，只有绑定了*.car的队列才可收到消息

      //  productService.sendDataToExchange("topicexchange","ed.mail", "ed.mail"+System.currentTimeMillis());


      //  productService.sendDataToExchange("topicexchange","ed.car", "ed.car"+System.currentTimeMillis());

        productService.sendDataToExchange("topicexchange","t.car", "ed.car"+System.currentTimeMillis());


    }

    @Test
    public void  fanOut(){
        productService.sendDataToExchange("fanoutexchange","", "----fanoutexchange----"+System.currentTimeMillis());
    }

}