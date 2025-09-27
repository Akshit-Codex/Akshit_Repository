package com.example.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Token extends Base
{
    private String tokenValue;
    private Date expiryAt;

    @ManyToOne
    private User user;
}

/*
* User    Token
* 1 ------- M
* 1 ------- 1
* Cardinality of User and Token: 1:M
* */

