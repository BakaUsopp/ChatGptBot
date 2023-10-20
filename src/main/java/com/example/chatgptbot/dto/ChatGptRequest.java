package com.example.chatgptbot.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatGptRequest {

    private String model;
    private List<Message> messages;

    public ChatGptRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<Message>();
        this.messages.add(new Message("user", prompt));
    }
}
