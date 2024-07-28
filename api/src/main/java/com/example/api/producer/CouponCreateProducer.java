package com.example.api.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.CompletableFuture;

@Component
public class CouponCreateProducer {

    private final KafkaTemplate<String, Long> kafkaTemplate;

    public CouponCreateProducer(KafkaTemplate<String, Long> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void create(Long userId){
        kafkaTemplate.send("coupon_create",userId);

    }
//    public void create(Long userId) {
//        ListenableFuture<SendResult<String, Long>> future = (ListenableFuture<SendResult<String, Long>>) kafkaTemplate.send("coupon_create", userId);
//
//        future.addCallback(new ListenableFutureCallback<SendResult<String, Long>>() {
//            @Override
//            public void onSuccess(SendResult<String, Long> result) {
//                System.out.println("Message sent successfully: " + result.getProducerRecord().value());
//            }
//
//            @Override
//            public void onFailure(Throwable ex) {
//                System.err.println("Failed to send message: " + ex.getMessage());
//            }
//        });
//    }
}
