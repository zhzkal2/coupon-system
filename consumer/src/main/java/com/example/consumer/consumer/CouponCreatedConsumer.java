package com.example.consumer.consumer;

import com.example.consumer.domain.Coupon;
import com.example.consumer.domain.FailedEvent;
import com.example.consumer.repository.CouponRepository;
import com.example.consumer.repository.FailedEventRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class CouponCreatedConsumer {

    private final CouponRepository couponRepository;
    private final FailedEventRepository failedEventRepository;

    private final Logger logger = LoggerFactory.getLogger(CouponCreatedConsumer.class);

    public CouponCreatedConsumer(CouponRepository couponRepository, FailedEventRepository failedEventRepository) {
        this.couponRepository = couponRepository;
        this.failedEventRepository = failedEventRepository;
    }

    @KafkaListener(topics = "coupon_create",groupId = "group_1")
    public void listener(Long userId){


        try {
//            System.out.println("쿠폰 저장 성공 " + userId);
            couponRepository.save(new Coupon(userId));

        }catch (Exception e){

//            System.out.println("쿠폰 저장 실패 " + userId);
            logger.error("failed to create coupon : "+ userId);
            failedEventRepository.save(new FailedEvent(userId));
        }
    }

}
