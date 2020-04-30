package com.codimiracle.web.notification.middleware.template;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotificationTemplateTest {

    @Resource
    private NotificationTemplate notificationTemplate;

    @Test
    void send() throws InterruptedException {
        notificationTemplate.send("1", "2", "test", "Hello world");
        Thread.sleep(1000);
    }

    @Test
    void sendPlaintext() {
        notificationTemplate.sendPlaintext("1", "2", "Hello");
    }

    @Test
    void sendVideo() {
    }

    @Test
    void sendVoice() {
    }

    @Test
    void sendPicture() {
    }

    @Test
    void sendApp() {
    }

    @Test
    void sendFile() {
    }

    @Test
    void bind() {
    }
}