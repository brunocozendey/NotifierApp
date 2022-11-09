package com.itau.NotifierApp.service;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sns.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class NotificationPusblisher {
    private static final Logger log = LoggerFactory.getLogger(NotificationPusblisher.class);

    private AmazonSNS snsClient;
    private Topic productEventsTopic;

    public NotificationPusblisher(AmazonSNS snsClient,
                            @Qualifier("NotificationTopic")Topic productEventsTopic) {
        this.snsClient = snsClient;
        this.productEventsTopic = productEventsTopic;
    }

    public void publishNotificationEvent(String message) {
        PublishResult publishResult = snsClient.publish(
                productEventsTopic.getTopicArn(),
                message);
        log.info("SNS MessageId: {}", publishResult.getMessageId());
    }
}
