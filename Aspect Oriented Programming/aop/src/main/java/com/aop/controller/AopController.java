package com.aop.controller;

import com.aop.model.Aop;
import com.aop.serviceimpl.AopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project aop
 * User : suren_v
 * Date : 11/28/2019
 * Time : 9:30 AM
 */
@RestController
@RequestMapping("/welcome")
@CrossOrigin("*")
public class AopController {

    @Autowired
    private AopServiceImpl aopServiceImpl;

    @GetMapping()
    public void welcomeMessage() {
        this.aopServiceImpl.welcomeMessage(new Aop(1,"1010"));
    }
}
