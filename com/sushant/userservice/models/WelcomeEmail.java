package com.sushant.userservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WelcomeEmail {

    private String address, subject, body;

    public WelcomeEmail(String address, String subject, String body) {
        this.address = address;
        this.subject = subject;
        this.body = body;
    }
}
