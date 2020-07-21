package com.gabriellopesjds.vendasweb.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonSnsConfig {

    @Autowired
    private AmazonSnsProperties properties;

    @Bean
    public AmazonSNS amazonSNS(){
        var credentials = new BasicAWSCredentials(properties.getAccessKey(),properties.getSecretAccessKey());

        return AmazonSNSClientBuilder
            .standard()
            .withCredentials(new AWSStaticCredentialsProvider(credentials))
            .withRegion(properties.getRegion())
            .build();
    }
}