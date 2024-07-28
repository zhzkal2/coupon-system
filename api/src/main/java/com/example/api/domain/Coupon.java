package com.example.api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coupon {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;

    public Coupon(){
    }

    public Coupon(long userId) {
        this.userId=userId;
    }

    public long getId() {
        return id;
    }


}
