package com.codimiracle.web.notification.middleware.mq;

import com.codimiracle.web.notification.middleware.pojo.po.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotificationQueueServiceTest {
    @Resource
    private NotificationQueueService notificationQueueService;
    @Resource
    private NotificationPersistenceReceiver notificationPersistenceReceiver;

    @Test
    void send() throws InterruptedException {
        Notification notification = new Notification();
        notification.setSenderId("1");
        notification.setReceiverId("2");
        notification.setType("hello-test");
        notification.setPayload("Data to notification");
        final Notification[] result = new Notification[1];
        CountDownLatch countDownLatch = new CountDownLatch(1);
        NotificationPersistedHandler handler = (payload) -> {
            result[0] = payload;
            countDownLatch.countDown();
        };
        notificationPersistenceReceiver.addNotificationPersistedHandler(handler);
        notificationQueueService.send(notification);
        countDownLatch.await();
        assertNotNull(result[0]);
        assertEquals(notification.getSenderId(), result[0].getSenderId());
        assertEquals(notification.getReceiverId(), result[0].getReceiverId());
        assertEquals(notification.getPayload(), result[0].getPayload());
        assertNotNull(result[0].getCreatedAt());
        assertNotNull(result[0].getUpdatedAt());
        notificationPersistenceReceiver.removeNotificationPersistedHandler(handler);
    }

    @Test
    void sendWithCallback() throws InterruptedException {
        Notification notification = new Notification();
        notification.setSenderId("3");
        notification.setReceiverId("4");
        notification.setType("hello-test");
        notification.setPayload("Data to notification");
        final Notification[] result = new Notification[1];
        CountDownLatch countDownLatch = new CountDownLatch(1);
        NotificationPersistedHandler handler = (payload) -> {
            result[0] = payload;
            countDownLatch.countDown();
        };
        notificationPersistenceReceiver.addNotificationPersistedHandler(handler);
        notificationQueueService.send(notification, (message) -> {
            assertTrue(true);
            return message;
        });
        countDownLatch.await();
        assertNotNull(result[0]);
        assertEquals(notification.getSenderId(), result[0].getSenderId());
        assertEquals(notification.getReceiverId(), result[0].getReceiverId());
        assertEquals(notification.getPayload(), result[0].getPayload());
        assertNotNull(result[0].getCreatedAt());
        assertNotNull(result[0].getUpdatedAt());
        notificationPersistenceReceiver.removeNotificationPersistedHandler(handler);
    }
}