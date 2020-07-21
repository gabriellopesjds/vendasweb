package com.gabriellopesjds.vendasweb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public abstract class AbstractAmazonProperties {
    private String region;
    private String accessKey;
    private String secretAccessKey;
}
