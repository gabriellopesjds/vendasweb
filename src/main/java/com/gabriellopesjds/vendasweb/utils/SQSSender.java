package com.gabriellopesjds.vendasweb.utils;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageBatchRequest;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class SQSSender {

    @Autowired
    private AmazonSQS amazonSQS;

    public void publishMessage(String destinationName, String message) {
        final SendMessageRequest sendMessageRequest =
            new SendMessageRequest()
                    .withQueueUrl(destinationName)
                    .withMessageBody(message);

        amazonSQS.sendMessage(sendMessageRequest);
    }

    public void publishMessageBatch(String destinationName, List<String> messages) {
        final AtomicInteger index = new AtomicInteger();
        final List<SendMessageBatchRequestEntry> entries = messages.stream().map(message -> {
            final String messageId = String.valueOf(index.getAndIncrement());
            return new SendMessageBatchRequestEntry(messageId, message);
        }).collect(Collectors.toList());
        final SendMessageBatchRequest sendMessageRequest =
            new SendMessageBatchRequest().withQueueUrl(destinationName).withEntries(entries);

        amazonSQS.sendMessageBatch(sendMessageRequest);
    }
}
