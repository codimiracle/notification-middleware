package com.codimiracle.web.notification.middleware.service.impl;

import com.codimiracle.web.mybatis.contract.AbstractService;
import com.codimiracle.web.notification.middleware.pojo.po.Notification;
import com.codimiracle.web.notification.middleware.service.NotificationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NotificationServiceImpl extends AbstractService<String, Notification> implements NotificationService {
    @Override
    public void save(Notification model) {
        super.save(model);
        model.setCreatedAt(new Date());
        model.setUpdatedAt(new Date());
    }
}
