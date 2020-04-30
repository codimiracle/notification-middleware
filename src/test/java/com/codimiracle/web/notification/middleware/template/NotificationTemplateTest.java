package com.codimiracle.web.notification.middleware.template;

import com.codimiracle.web.notification.middleware.mq.NotificationPersistedHandler;
import com.codimiracle.web.notification.middleware.mq.NotificationPersistenceReceiver;
import com.codimiracle.web.notification.middleware.pojo.po.Notification;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class NotificationTemplateTest {

    @Resource
    private NotificationTemplate notificationTemplate;
    @Resource
    private NotificationPersistenceReceiver notificationPersistenceReceiver;

    @Test
    void send() throws InterruptedException {
        final String senderId = "1";
        final String receiverId = "2";
        final String type = "test";
        final String payload = "Hello world";
        notificationTemplate.send(senderId, receiverId, type, payload);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final Notification[] result = new Notification[1];
        NotificationPersistedHandler handler = (notification) -> {
            result[0] = notification;
            countDownLatch.countDown();
        };
        notificationPersistenceReceiver.addNotificationPersistedHandler(handler);
        countDownLatch.await();
        assertEquals(senderId, result[0].getSenderId());
        assertEquals(receiverId, result[0].getReceiverId());
        assertEquals(type, result[0].getType());
        assertEquals(payload, result[0].getPayload());
        notificationPersistenceReceiver.removeNotificationPersistedHandler(handler);
    }

    @Test
    void sendPlaintext() throws InterruptedException {
        final String senderId = "1";
        final String receiverId = "2";
        final String payload = "Hello world";
        notificationTemplate.sendPlaintext(senderId, receiverId, payload);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final Notification[] result = new Notification[1];
        NotificationPersistedHandler handler = (notification) -> {
            result[0] = notification;
            countDownLatch.countDown();
        };
        notificationPersistenceReceiver.addNotificationPersistedHandler(handler);
        countDownLatch.await();
        assertEquals(senderId, result[0].getSenderId());
        assertEquals(receiverId, result[0].getReceiverId());
        assertEquals(Notification.NOTIFICATION_TYPE_PLAINTEXT, result[0].getType());
        assertEquals(payload, result[0].getPayload());
        notificationPersistenceReceiver.removeNotificationPersistedHandler(handler);

    }

    @Test
    void sendVideo() throws InterruptedException {
        final String senderId = "1";
        final String receiverId = "2";
        final String payload = "Hello world";
        notificationTemplate.sendVideo(senderId, receiverId, payload);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final Notification[] result = new Notification[1];
        NotificationPersistedHandler handler = (notification) -> {
            result[0] = notification;
            countDownLatch.countDown();
        };
        notificationPersistenceReceiver.addNotificationPersistedHandler(handler);
        countDownLatch.await();
        assertEquals(senderId, result[0].getSenderId());
        assertEquals(receiverId, result[0].getReceiverId());
        assertEquals(Notification.NOTIFICATION_TYPE_VIDEO, result[0].getType());
        assertEquals(payload, result[0].getPayload());
        notificationPersistenceReceiver.removeNotificationPersistedHandler(handler);
    }

    @Test
    void sendVoice() throws InterruptedException {
        final String senderId = "1";
        final String receiverId = "2";
        final String payload = "Hello world";
        notificationTemplate.sendVideo(senderId, receiverId, payload);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final Notification[] result = new Notification[1];
        NotificationPersistedHandler handler = (notification) -> {
            result[0] = notification;
            countDownLatch.countDown();
        };
        notificationPersistenceReceiver.addNotificationPersistedHandler(handler);
        countDownLatch.await();
        assertEquals(senderId, result[0].getSenderId());
        assertEquals(receiverId, result[0].getReceiverId());
        assertEquals(Notification.NOTIFICATION_TYPE_VIDEO, result[0].getType());
        assertEquals(payload, result[0].getPayload());
        notificationPersistenceReceiver.removeNotificationPersistedHandler(handler);
    }

    @Test
    void sendPicture() throws InterruptedException {
        final String senderId = "1";
        final String receiverId = "2";
        final String payload = "Hello world";
        notificationTemplate.sendPicture(senderId, receiverId, payload);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final Notification[] result = new Notification[1];
        NotificationPersistedHandler handler = (notification) -> {
            result[0] = notification;
            countDownLatch.countDown();
        };
        notificationPersistenceReceiver.addNotificationPersistedHandler(handler);
        countDownLatch.await();
        assertEquals(senderId, result[0].getSenderId());
        assertEquals(receiverId, result[0].getReceiverId());
        assertEquals(Notification.NOTIFICATION_TYPE_PICTURE, result[0].getType());
        assertEquals(payload, result[0].getPayload());
        notificationPersistenceReceiver.removeNotificationPersistedHandler(handler);
    }

    @Test
    void sendApp() throws InterruptedException {
        final String senderId = "1";
        final String receiverId = "2";
        final String payload = "Hello world";
        notificationTemplate.sendApp(senderId, receiverId, payload);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final Notification[] result = new Notification[1];
        NotificationPersistedHandler handler = (notification) -> {
            result[0] = notification;
            countDownLatch.countDown();
        };
        notificationPersistenceReceiver.addNotificationPersistedHandler(handler);
        countDownLatch.await();
        assertEquals(senderId, result[0].getSenderId());
        assertEquals(receiverId, result[0].getReceiverId());
        assertEquals(Notification.NOTIFICATION_TYPE_APP, result[0].getType());
        assertEquals(payload, result[0].getPayload());
        notificationPersistenceReceiver.removeNotificationPersistedHandler(handler);
    }

    @Test
    void sendFile() throws InterruptedException {
        final String senderId = "1";
        final String receiverId = "2";
        final String payload = "Hello world";
        notificationTemplate.sendFile(senderId, receiverId, payload);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final Notification[] result = new Notification[1];
        NotificationPersistedHandler handler = (notification) -> {
            result[0] = notification;
            countDownLatch.countDown();
        };
        notificationPersistenceReceiver.addNotificationPersistedHandler(handler);
        countDownLatch.await();
        assertEquals(senderId, result[0].getSenderId());
        assertEquals(receiverId, result[0].getReceiverId());
        assertEquals(Notification.NOTIFICATION_TYPE_FILE, result[0].getType());
        assertEquals(payload, result[0].getPayload());
        notificationPersistenceReceiver.removeNotificationPersistedHandler(handler);
    }

    @Test
    void sendVice() throws InterruptedException {
        final String senderId = "1";
        final String receiverId = "2";
        final String payload = "Hello world";
        notificationTemplate.sendVoice(senderId, receiverId, payload);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final Notification[] result = new Notification[1];
        NotificationPersistedHandler handler = (notification) -> {
            result[0] = notification;
            countDownLatch.countDown();
        };
        notificationPersistenceReceiver.addNotificationPersistedHandler(handler);
        countDownLatch.await();
        assertEquals(senderId, result[0].getSenderId());
        assertEquals(receiverId, result[0].getReceiverId());
        assertEquals(Notification.NOTIFICATION_TYPE_VOICE, result[0].getType());
        assertEquals(payload, result[0].getPayload());
        notificationPersistenceReceiver.removeNotificationPersistedHandler(handler);
    }

    @Test
    void bind() throws InterruptedException {
        NotificationTemplate.NotificationBondTemplate notificationBondTemplate = notificationTemplate.bind("1", "2");
        assertNotNull(notificationBondTemplate);
        final CountDownLatch[] countDownLatch = new CountDownLatch[]{new CountDownLatch(1)};
        final Notification[] result = new Notification[1];
        NotificationPersistedHandler handler = (notification) -> {
            result[0] = notification;
            countDownLatch[0].countDown();
        };
        notificationPersistenceReceiver.addNotificationPersistedHandler(handler);
        final String type = "test";
        final String payload = "test-bond-template";
        notificationBondTemplate.send("test", "test-bond-template");
        countDownLatch[0].await();
        assertEquals(type, result[0].getType());
        assertEquals(payload, result[0].getPayload());

        countDownLatch[0] = new CountDownLatch(1);
        notificationBondTemplate.sendPicture("test-bond-template");
        countDownLatch[0].await();
        assertEquals(Notification.NOTIFICATION_TYPE_PICTURE, result[0].getType());
        assertEquals(payload, result[0].getPayload());

        countDownLatch[0] = new CountDownLatch(1);
        notificationBondTemplate.sendPlaintext("test-bond-template");
        countDownLatch[0].await();
        assertEquals(Notification.NOTIFICATION_TYPE_PLAINTEXT, result[0].getType());
        assertEquals(payload, result[0].getPayload());

        countDownLatch[0] = new CountDownLatch(1);
        notificationBondTemplate.sendApp("test-bond-template");
        countDownLatch[0].await();
        assertEquals(Notification.NOTIFICATION_TYPE_APP, result[0].getType());
        assertEquals(payload, result[0].getPayload());

        countDownLatch[0] = new CountDownLatch(1);
        notificationBondTemplate.sendFile("test-bond-template");
        countDownLatch[0].await();
        assertEquals(Notification.NOTIFICATION_TYPE_FILE, result[0].getType());
        assertEquals(payload, result[0].getPayload());

        countDownLatch[0] = new CountDownLatch(1);
        notificationBondTemplate.sendVideo("test-bond-template");
        countDownLatch[0].await();
        assertEquals(Notification.NOTIFICATION_TYPE_VIDEO, result[0].getType());
        assertEquals(payload, result[0].getPayload());

        countDownLatch[0] = new CountDownLatch(1);
        notificationBondTemplate.sendVoice("test-bond-template");
        countDownLatch[0].await();
        assertEquals(Notification.NOTIFICATION_TYPE_VOICE, result[0].getType());
        assertEquals(payload, result[0].getPayload());

        notificationPersistenceReceiver.removeNotificationPersistedHandler(handler);
    }


}