package com.gabriellopesjds.vendasweb.config;

import com.amazon.sqs.javamessaging.ProviderConfiguration;
import com.amazon.sqs.javamessaging.SQSConnectionFactory;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import javax.annotation.PostConstruct;

@Configuration
public class AmazonSqsConfig {

    @Autowired
    private AmazonSqsProperties properties;

    private SQSConnectionFactory connectionFactory;

    @PostConstruct
    public void init() {
        connectionFactory = createSQSConnectionFactory();
    }

    @Bean
    public SQSConnectionFactory createSQSConnectionFactory() {
        return new SQSConnectionFactory(new ProviderConfiguration(), amazonSQS());
    }

    @Bean
    public AmazonSQS amazonSQS() {
        var credentials = new BasicAWSCredentials(properties.getAccessKey(),properties.getSecretAccessKey());

        return AmazonSQSClientBuilder
                    .standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion(properties.getRegion())
                    .build();
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    @Bean
    public JmsTemplate defaultJmsTemplate() {
        return new JmsTemplate(connectionFactory);
    }
}