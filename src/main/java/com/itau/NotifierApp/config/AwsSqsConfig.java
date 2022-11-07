package com.itau.NotifierApp.config;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.itau.NotifierApp.service.AwsSqsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.DynamicDestinationResolver;

import javax.jms.Session;

import static org.springframework.jms.listener.DefaultMessageListenerContainer.CACHE_AUTO;

@Configuration
@EnableJms
public class AwsSqsConfig {
    @Autowired
    AwsSqsClient awsSqsClient;
    private SQSConnectionFactory connectionFactory;

    @Value("${cloud.aws.region.static}")
    private String region;

    @Value("${cloud.aws.credentials.access-key}")
    private String awsAccessKey;

    @Value("${cloud.aws.credentials.secret-key}")
    private String awsSecretKey;

    @Value("${cloud.aws.end-point.uri}")
    private String uri;

    @Value("${cloud.aws.end-point.queue}")
    private String queue;

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        this.connectionFactory =
                SQSConnectionFactory.builder()
                        .withEndpoint(uri)
                        .withAWSCredentialsProvider(new DefaultAWSCredentialsProviderChain())
                        .withNumberOfMessagesToPrefetch(0)
                        .build();

        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
        cachingConnectionFactory.setTargetConnectionFactory(this.connectionFactory);
        cachingConnectionFactory.setReconnectOnException(true);

        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(this.connectionFactory);
        factory.setDestinationResolver(new DynamicDestinationResolver());
        factory.setConcurrency("3-10");
        factory.setSessionAcknowledgeMode(Session.AUTO_ACKNOWLEDGE);
        factory.setCacheLevel(CACHE_AUTO);
        return factory;
    }

    @Bean
    public JmsTemplate defaultJmsTemplate() {
        return new JmsTemplate(this.connectionFactory);
    }
}
