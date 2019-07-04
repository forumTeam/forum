package com.forum.common.listener.rabbitmq.BaseRabbitmqListener;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import java.nio.charset.StandardCharsets;

public class BaseListener implements ChannelAwareMessageListener {

    private Logger logger = Logger.getLogger(getClass());

    @Override
    public void onMessage(Message message, Channel channel) throws Exception {
        try {
            logger.warn("消费者2接收到消息=================>" + new String(message.getBody(), StandardCharsets.UTF_8));
            JSONObject jsonObject = getJSONObject(new String(message.getBody(), StandardCharsets.UTF_8));
            JSONArray jsonArray = getJSONArray(new String(message.getBody(), StandardCharsets.UTF_8));

            if (jsonObject == null && jsonArray == null) throw new Exception("无效的消息");
            if (jsonObject != null) {
                logger.warn("jsonObject消费者2接收到消息=================>" + jsonObject.toJSONString());
                onMessage(message, channel, jsonObject);
            }
            if (jsonArray != null) {
                logger.warn("jsonArray消费者2接收到消息=================>" + jsonArray.toJSONString());
                onMessage(message, channel, jsonArray);
            }
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }

    }


    public void ack(Message message, Channel channel) throws Exception {
        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
    }


    private JSONObject getJSONObject(String body) {
        if (body == null) return null;
        if (body.startsWith("{") && body.endsWith("}")) return JSONObject.parseObject(body);
        return null;
    }

    private JSONArray getJSONArray(String body) {
        if (body == null) return null;
        if (body.startsWith("[") && body.endsWith("]")) return JSONObject.parseArray(body);
        return null;
    }


    public void onMessage(Message message, Channel channel, JSONObject jsonObject) throws Exception {
        throw new Exception("请复写此方法...");
    }

    public void onMessage(Message message, Channel channel, JSONArray jsonArray) throws Exception {
        throw new Exception("请复写此方法...");
    }

}

