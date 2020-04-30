package com.codimiracle.web.notification.middleware.mq;

import com.codimiracle.web.notification.middleware.pojo.po.Notification;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class NotificationQueueService {
    @Resource
    private Queue queue;
    @Resource
    private Exchange exchange;
    @Resource
    private Binding binding;

    @Resource
    private AmqpTemplate amqpTemplate;

    public void send(Notification notification) {
        String routingKey = binding.getRoutingKey().replace("#", String.format("%s-%s", notification.getSenderId(), notification.getReceiverId()));
        amqpTemplate.convertAndSend(exchange.getName(), routingKey, notification);
    }
}
