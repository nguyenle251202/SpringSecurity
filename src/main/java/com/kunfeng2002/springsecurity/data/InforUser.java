package com.kunfeng2002.springsecurity.data;

import com.kunfeng2002.springsecurity.model.Infor;
import com.kunfeng2002.springsecurity.model.User;

import java.util.ArrayList;
import java.util.List;

public class InforUser {
    private List<Infor> infors = new ArrayList<>(
            List.of(
                    new Infor(1, "0123456789", "HaNoi"),
                    new Infor(2, "0987654321", "HaNam"),
                    new Infor(3, "0897564231", "HaTay")
            ));
    public List<Infor> getInfors() {
        return infors;
    }
}
