package com.cxzcanying.winterproject.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import javax.management.Notification;

/**
 * @author 21311
 */
@Controller
public class NotificationWebSocket {

    @MessageMapping("/notifications")
    @SendTo("/topic/notifications")
    public Notification sendNotification(Notification notification) {
        return notification;
    }
} 