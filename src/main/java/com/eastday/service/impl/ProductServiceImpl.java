package com.eastday.service.impl;

import com.eastday.service.IProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl  implements IProductService {

    @Resource
    private AmqpTemplate amqpTemplate;

    private final static Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Override
    public void sendDataToQueue(String routingKey, Object object) {

        try {
            amqpTemplate.convertAndSend(routingKey, object);
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }

    @Override
    public void sendDataToExchange(String exchange, String queueKey, Object object) {

        try {
            amqpTemplate.convertAndSend(exchange,queueKey, object);
        } catch (Exception e) {
            logger.error(e.toString());
        }
    }


}
