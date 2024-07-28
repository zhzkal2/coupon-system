package com.example.api.service;

import com.example.api.domain.Coupon;
import com.example.api.producer.CouponCreateProducer;
import com.example.api.repository.CouponCountRepository;
import com.example.api.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {

    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;
    private final CouponCreateProducer couponCreateProducer;


    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository, CouponCreateProducer couponCreateProducer){
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
        this.couponCreateProducer = couponCreateProducer;
    }

    //쿠폰 발급 전에 발급된 쿠폰의 개수를 증가시키고 발급된 쿠폰의 개수가 100개보다 많다면 발급하지 않음
    public void apply(Long userId){

        Long count = couponCountRepository.increment();

        if (count>100){
            return;
        }


        couponCreateProducer.create(userId);
//        couponRepository.save(new Coupon(userId));
    }





}
