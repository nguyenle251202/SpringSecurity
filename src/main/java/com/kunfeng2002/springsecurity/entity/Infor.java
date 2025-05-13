package com.kunfeng2002.springsecurity.entity;

import jakarta.persistence.Id;

public class Infor {
    @Id
    private int id;
    private String tel;
    private String address;
}
