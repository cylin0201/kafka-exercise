package com.ureca.kafkaconsumer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tools.jackson.databind.ObjectMapper;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmailSendMessage {
    private String from;
    private String to;
    private String subject;
    private String body;

    public static EmailSendMessage fromJson(String json) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, EmailSendMessage.class);
    }
}
