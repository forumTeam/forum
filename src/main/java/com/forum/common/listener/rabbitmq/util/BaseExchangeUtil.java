package com.forum.common.listener.rabbitmq.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


@Service
public class BaseExchangeUtil {


    private Logger logger = LoggerFactory.getLogger(BaseExchangeUtil.class);

    /**
     * 给交换机队列发送消息
     *
     * @param rabbitTemplate
     * @param queueName
     * @param message
     * @return
     * @throws Exception
     */
    public boolean send(RabbitTemplate rabbitTemplate, String queueName, Object message) throws Exception {
        logger.warn("<================== 发送消息给交换机前参数校验开始 ==================>");
        try {
            if (rabbitTemplate == null) throw new Exception("rabbitTemplate 参数不能为null");
            if (rabbitTemplate.getExchange() == null || rabbitTemplate.getExchange().trim().equals(""))
                throw new Exception("rabbitTemplate 没有绑定交换机");
            if (queueName == null || queueName.trim().equals("")) throw new Exception("queueName 没有要发送的队列");
            if (message == null || message.equals("")) throw new Exception("没有要发送的消息");
            logger.warn("<================== 发送消息给交换机前参数校验结束 ==================>");
            logger.warn("<================== 开始发送消息 ==================>");
            rabbitTemplate.convertAndSend(queueName, message);
            logger.warn("<================== 发送消息到【" + queueName + "】队列成功 ==================>");
        } catch (Exception e) {
            logger.warn("<================== 发送消息到【" + queueName + "】队列失败 ==================>");
            logger.error(e.getMessage(), e);
            return Boolean.FALSE;
        }
        return true;
    }

}
