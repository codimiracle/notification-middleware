package com.codimiracle.web.notification.middleware.mq;

import com.codimiracle.web.notification.middleware.pojo.po.Notification;
import com.codimiracle.web.notification.middleware.service.NotificationService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class NotificationPersistentReceiver {
    @Resource
    private NotificationService notificationService;

    @Autowired
    private List<NotificationHandler> notificationPersistedHandlers;

    @RabbitListener(queues = "${notification-middleware.notification-queue}")
    public void handleMessage(Notification payload) {
        notificationService.save(payload);
    }
}
