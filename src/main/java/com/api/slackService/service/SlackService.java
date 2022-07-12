package com.api.slackService.service;

import java.io.IOException;
import org.springframework.stereotype.Service;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.chat.ChatPostMessageRequest;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SlackService {

    public void postSlackMessage(String message){
        log.info("postSlackMessage");
        String token = "xoxb-3775197685798-3783797940245-hqwp0XyfCcx5Iy12cH2TiNXh";
        String channel = "#test";

        try{
            MethodsClient methods = Slack.getInstance().methods(token);
            ChatPostMessageRequest request = ChatPostMessageRequest.builder()
                    .channel(channel)
                    .text(message)
                    .build();

            methods.chatPostMessage(request);
           
            log.info("보냄");
        } catch (SlackApiException | IOException e) {
            log.error(e.getMessage());
        }
    }
}