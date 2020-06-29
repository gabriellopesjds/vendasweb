package com.gabriellopesjds.vendasweb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(value = "api.sns.topic")
public class AmazonSnsTopic {
    private String topicSales;
}
