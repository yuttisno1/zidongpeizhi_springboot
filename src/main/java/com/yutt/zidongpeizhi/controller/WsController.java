package com.yutt.zidongpeizhi.controller;

import netscape.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class WsController {
    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/ws/chat")
    public void handleChat(Principal principal, String msg) {
        String destUser = msg.substring(msg.lastIndexOf(";") + 1, msg.length());
        String message = msg.substring(0, msg.lastIndexOf(";"));
       // messagingTemplate.convertAndSendToUser(destUser, "/queue/chat", new ChatResp(message, principal.getName()));
    }
}
