package com.lq.demo.domain;

import lombok.Data;

@Data
public class User {
    private int id;
    private String userName;
    private String password;
    private int power;

}
