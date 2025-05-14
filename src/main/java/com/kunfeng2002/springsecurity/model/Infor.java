package com.kunfeng2002.springsecurity.model;

import jakarta.persistence.Id;

public class Infor {
    @Id
    private int id;
    private String tel;
    private String address;

    public Infor(int id, String tel, String address) {
        this.id = id;
        this.tel = tel;
        this.address = address;
    }

    public Infor() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Infor{" +
                "id=" + id +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
