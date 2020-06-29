package com.gabriellopesjds.vendasweb.utils;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SNSSender {

    @Autowired
    private AmazonSNS amazonSNS;

    public PublishResult publishMessage(String topic, String message){
        return this.amazonSNS.publish(topic, message);
    }


}
