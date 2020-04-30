package com.codimiracle.web.notification.middleware.template;

import com.codimiracle.web.notification.middleware.mq.NotificationQueueService;
import com.codimiracle.web.notification.middleware.pojo.po.Notification;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class NotificationTemplate {
    @Resource
    private NotificationQueueService notificationQueueService;

    public void send(String senderId, String receiverId, String type, String payload) {
        Notification notification = new Notification();
        notification.setSenderId(senderId);
        notification.setReceiverId(receiverId);
        notification.setType(type);
        notification.setPayload(payload);
        notificationQueueService.send(notification);
    }

    public void sendPlaintext(String senderId, String receiverId, String payload) {
        this.send(senderId, receiverId, Notification.NOTIFICATION_TYPE_PLAINTEXT, payload);
    }

    public void sendVideo(String senderId, String receiverId, String payload) {
        this.send(senderId, receiverId, Notification.NOTIFICATION_TYPE_VIDEO, payload);
    }

    public void sendVoice(String senderId, String receiverId, String payload) {
        this.send(senderId, receiverId, Notification.NOTIFICATION_TYPE_VOICE, payload);
    }

    public void sendPicture(String senderId, String receiverId, String payload) {
        this.send(senderId, receiverId, Notification.NOTIFICATION_TYPE_PICTURE, payload);
    }

    public void sendApp(String senderId, String receiverId, String payload) {
        this.send(senderId, receiverId, Notification.NOTIFICATION_TYPE_APP, payload);
    }

    public void sendFile(String senderId, String receiverId, String payload) {
        this.send(senderId, receiverId, Notification.NOTIFICATION_TYPE_FILE, payload);
    }

    public NotificationBondTemplate bind(String senderId, String receiverId) {
        return new NotificationBondTemplate(senderId, receiverId, this);
    }

    public static class NotificationBondTemplate {
        private final String senderId;
        private final String receiverId;
        private NotificationTemplate notificationTemplate;

        private NotificationBondTemplate(String senderId, String receiverId, NotificationTemplate notificationTemplate) {
            this.senderId = senderId;
            this.receiverId = receiverId;
            this.notificationTemplate = notificationTemplate;
        }

        public void send(String type, String payload) {
            notificationTemplate.send(this.senderId, this.receiverId, type, payload);
        }

        public void sendPlaintext(String payload) {
            notificationTemplate.sendPlaintext(this.senderId, this.receiverId, payload);
        }

        public void sendVideo(String payload) {
            notificationTemplate.sendVideo(this.senderId, this.receiverId, payload);
        }

        public void sendVoice(String payload) {
            notificationTemplate.sendVoice(this.senderId, this.receiverId, payload);
        }

        public void sendPicture(String payload) {
            notificationTemplate.sendPicture(this.senderId, this.receiverId, payload);
        }

        public void sendApp(String payload) {
            notificationTemplate.sendApp(this.senderId, this.receiverId, payload);
        }

        public void sendFile(String payload) {
            notificationTemplate.sendFile(this.senderId, this.receiverId, payload);
        }
    }
}
