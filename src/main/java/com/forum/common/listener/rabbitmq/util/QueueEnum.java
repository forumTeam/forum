package com.forum.common.listener.rabbitmq.util;

public enum QueueEnum {

    testRabbitMessage("testRabbitMessage"),
    testRabbitMessageError("testRabbitMessageError");


    private QueueEnum(String queueName) {
        this.queueName = queueName;
    }

    private String queueName;


    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }
}
