package com.api.slackService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.slackService.service.SlackService;

import lombok.extern.slf4j.Slf4j;
    
@Controller
@Slf4j
public class SlackController {
       
    @Autowired
    private SlackService slackService; 

    @RequestMapping("/slack")
    public String home() {
        log.info("slack controller");
        slackService.postSlackMessage("slack message !@#!@#!@#");
        return "index";
    }
}