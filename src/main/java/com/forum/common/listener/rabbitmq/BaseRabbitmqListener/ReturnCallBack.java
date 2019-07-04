package com.forum.common.listener.rabbitmq.BaseRabbitmqListener;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReturnCallBack implements RabbitTemplate.ReturnCallback {

    private Logger logger = Logger.getLogger(getClass());

    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        try {
            logger.warn("<============生产者发送消息失败=================>" + JSON.parseObject(new String(message.getBody(), "UTF-8")) + "i>>>>>>" + i + "s>>>>>>>" + s + "s1>>>" + s1 + "s2>>>>>>" + s2);
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }


    }
}
