package com.forum.common.listener.rabbitmq.util;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class TeskExchangeUtil extends BaseExchangeUtil {

    @Resource(name = "rabbitTemplate")
    private RabbitTemplate rabbitTemplate;


    public boolean send(String queueName, Object message) throws Exception {
        return super.send(rabbitTemplate, queueName, message);
    }


}
