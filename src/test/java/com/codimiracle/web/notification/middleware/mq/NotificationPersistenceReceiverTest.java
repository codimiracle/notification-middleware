package com.codimiracle.web.notification.middleware.mq;

import com.codimiracle.web.notification.middleware.pojo.po.Notification;
import com.codimiracle.web.notification.middleware.service.NotificationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotificationPersistentReceiverTest {
    @Resource
    private NotificationService notificationService;
    @Autowired
    private NotificationPersistentReceiver notificationPersistentReceiver;

    @Test
    void handleMessage() {
        Notification notification = new Notification();
        notification.setSenderId("1");
        notification.setReceiverId("2");
        notification.setType("hello-test");
        notification.setPayload("Data to notification");
        notificationPersistentReceiver.handleMessage(notification);
        Notification result = notificationService.findById(notification.getId());
        assertNotNull(result);
        assertNotNull(result);
        assertEquals(notification.getSenderId(), result.getSenderId());
        assertEquals(notification.getReceiverId(), result.getReceiverId());
        assertEquals(notification.getId(), result.getId());
        assertEquals(notification.getPayload(), result.getPayload());
        assertNotNull(result.getCreatedAt());
        assertNotNull(result.getUpdatedAt());
    }
}