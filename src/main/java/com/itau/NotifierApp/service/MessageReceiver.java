package com.itau.NotifierApp.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;



@Service
public class MessageReceiver {
    private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class);
    public void receiveMessage(String message,
                               @Header("SenderId") String senderId) {
        log.info("message received {} {}",senderId,message);
    }
}
