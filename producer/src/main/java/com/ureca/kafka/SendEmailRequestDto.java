package com.ureca.kafka;

import lombok.Getter;

@Getter
public class SendEmailRequestDto {
    private String from;
    private String to;
    private String subject;
    private String body;
}
