package com.longe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("consumer")
    public String consumer(){

        String result = restTemplate.getForObject("http://PROVIDER-SERVICE/provider", String.class);
        return result;
    }

    @RequestMapping("consumer/two")
    public String consumerTwo(){

        String result = restTemplate.getForObject("http://PROVIDER-SERVICE-TWO/provider", String.class);
        return result;
    }
}
