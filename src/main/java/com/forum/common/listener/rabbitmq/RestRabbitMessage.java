package com.forum.common.listener.rabbitmq;

import com.alibaba.fastjson.JSONObject;
import com.forum.common.listener.rabbitmq.BaseRabbitmqListener.BaseListener;
import com.forum.repository.domain.Information;
import com.forum.repository.mapper.InformationMapper;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RestRabbitMessage extends BaseListener {

    Logger logger = LoggerFactory.getLogger(RestRabbitMessage.class);

    @Autowired
    private InformationMapper informationMapper;


    @Override
    @Transactional
    public void onMessage(Message message, Channel channel, JSONObject jsonObject) {
        try {
            Information information = this.getInformation(jsonObject);
            if (informationMapper.insertSelective(information) <= 0) throw new Exception("添加消息失败！");
            ack(message, channel);
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
    }


    private Information getInformation(JSONObject jsonObject) {
        Information information = new Information();
        information.setPkMessageId(jsonObject.getLong("pkMessageId"));
        information.setFkAdministratorId(jsonObject.getLong("fkAdministratorId"));
        information.setFkUserId(jsonObject.getLong("fkUserId"));
        information.setContent(jsonObject.getString("content"));
        return information;
    }


}
