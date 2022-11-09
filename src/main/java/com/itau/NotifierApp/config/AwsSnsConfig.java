package com.itau.NotifierApp.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsSnsConfig {
    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.sns.topic}")
    private String topic;

    @Value("${cloud.aws.sns.uri}")
    private String uri;


    @Bean
    public AmazonSNS snsClient() {
        return AmazonSNSClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(uri,region))
                .build();
    }

    @Bean(name = "NotificationTopic")
    public Topic snsProductEventsTopic() {
        return new Topic().withTopicArn(topic);
    }

}
