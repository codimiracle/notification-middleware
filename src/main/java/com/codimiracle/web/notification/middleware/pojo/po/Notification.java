package com.codimiracle.web.notification.middleware.pojo.po;

import com.codimiracle.web.mybatis.contract.annotation.LogicDelete;
import com.codimiracle.web.mybatis.contract.annotation.LogicDeletedDate;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
public class Notification {
    public static final String NOTIFICATION_TYPE_APP = "app";
    public static final String NOTIFICATION_TYPE_FILE = "file";
    public static final String NOTIFICATION_TYPE_VOICE = "voice";
    public static final String NOTIFICATION_TYPE_VIDEO = "video";
    public static final String NOTIFICATION_TYPE_PICTURE = "picture";
    public static final String NOTIFICATION_TYPE_PLAINTEXT = "plaintext";

    @Id
    private String id;
    private String type;
    private String payload;

    @Column(name = "sender_id")
    private String senderId;
    @Column(name = "receiver_id")
    private String receiverId;

    private Boolean read;
    private Date createdAt;
    private Date updatedAt;

    @LogicDelete
    private Boolean deleted;
    @LogicDeletedDate
    private Date deletedAt;
}
