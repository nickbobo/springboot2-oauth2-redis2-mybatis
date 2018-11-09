package com.nick.controller;

import com.nick.properties.MyProperties1;

import jdk.nashorn.internal.ir.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 读取application.yml中的my1
 * Created by nick on 2018/11/7.
 */
//@SpringBootApplication
@RequestMapping("/properties")
@RestController
public class PropertiesController {

    private static final Logger log = LoggerFactory.getLogger(PropertiesController.class);

    @Autowired
    private final MyProperties1 myProperties1;

    @Autowired
    public PropertiesController(MyProperties1 myProperties1) {
        this.myProperties1 = myProperties1;
    }

    @GetMapping("/1")
    public MyProperties1 myProperties1() {
        log.info("=================================================================================================");
        log.info(myProperties1.toString());
        log.info("=================================================================================================");
        return myProperties1;
    }

//    @RequestMapping({"/2",""})
//    public String login(HttpServletRequest request){
////        log.info(HttpUtils.getIpAddr(request));
//        return "index";
//    }
}
