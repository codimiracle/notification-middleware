package com.codimiracle.web.notification.middleware.service.impl;

import com.codimiracle.web.notification.middleware.service.NotificationService;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NotificationServiceImplTest {
    @Resource
    private NotificationService notificationService;
}