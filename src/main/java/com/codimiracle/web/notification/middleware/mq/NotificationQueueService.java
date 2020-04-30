package com.codimiracle.web.notification.middleware.mq;
/*
 * MIT License
 *
 * Copyright (c) 2020 codimiracle
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
import com.codimiracle.web.notification.middleware.pojo.po.Notification;
import org.springframework.amqp.core.*;
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

    public void send(Notification notification, MessagePostProcessor callback) {
        String routingKey = binding.getRoutingKey().replace("#", String.format("%s-%s", notification.getSenderId(), notification.getReceiverId()));
        amqpTemplate.convertAndSend(exchange.getName(), routingKey, notification, callback);
    }
}
