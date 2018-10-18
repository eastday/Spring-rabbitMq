package com.eastday.comsumer;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OrderListener implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws Exception {


        try {
            //模拟异常
            // int i = 1/0;


            System.out.println(OrderListener.class.getSimpleName()
                    +new String(message.getBody()));

            //手动应答，确保收到消息
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {

            //重新放入队列
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);

            //抛弃此条消息
            //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);

            e.printStackTrace();

        }finally {

        }


    }
}
