package com.longe.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Value("${server.port}")
    private Integer serverPort;

    @RequestMapping("provider")
    public String provider(){

        return "服务提供者......" + serverPort;
    }
}
