package com.ureca.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendEmail(SendEmailRequestDto sendEmailRequestDto) {
        EmailSendMessage emailSendMessage = new EmailSendMessage(
                sendEmailRequestDto.getFrom(),
                sendEmailRequestDto.getTo(),
                sendEmailRequestDto.getSubject(),
                sendEmailRequestDto.getBody()
        );

        kafkaTemplate.send("email.send", toJsonString(emailSendMessage));
    }
    
    private String toJsonString(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        try{
            String message = mapper.writeValueAsString(object);
            return message;
        } catch(Exception e){
            throw new RuntimeException("Json 직렬화 실패");
        }
    }
}
