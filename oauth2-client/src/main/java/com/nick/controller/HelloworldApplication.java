package com.nick.controller;

import com.nick.bean.User;
import com.nick.config.RedisUtil;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;


/**
 * Created by nick on 2018/11/6.
 */

@Controller
//@Component
@RequestMapping

public class HelloworldApplication {

    private static final Logger log = LoggerFactory.getLogger(HelloworldApplication.class);


    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private RedisUtil redisUtil;

    @RequestMapping("/hello")
    String home() {
//        Logger logger =  LogManager.getLogger("weather");
        log.info("bala=balabalabalabala " );
        return "Hello World!！！！！";
    }

    @GetMapping("/index")
    public ModelAndView index() {

        ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("index");
        // 设置属性
        view.addObject("title", "我的第一个WEB页面");
        view.addObject("desc", "欢迎进入nick-web 系统");

        // 设置属性
        view.addObject("title", "我的第一个WEB页面");
        view.addObject("desc", "欢迎进入battcn-web 系统");
        User user = new User (1,"bobo","123456",4);
        view.addObject("user", user);
        return view;
    }

    @ResponseBody
    @GetMapping("/redis")
    public String redisTest(){
        ExecutorService executorService = Executors.newFixedThreadPool(1000);
        IntStream.range(0, 1000).forEach(i ->
                executorService.execute(() -> stringRedisTemplate.opsForValue().increment("kk", 1))
        );

        stringRedisTemplate.opsForValue().set("k1", "v1");
        final String k1 = stringRedisTemplate.opsForValue().get("k1");
        log.info("[字符缓存结果] - [{}]", k1);
        // TODO 以下只演示整合，具体Redis命令可以参考官方文档，Spring Data Redis 只是改了个名字而已，Redis支持的命令它都支持
//        String key = "battcn:user:1";
//        redisCacheTemplate.opsForValue().set(key, (Serializable) new User(1001, "u1", "pa",2));
//        // TODO 对应 String（字符串）
//        final User user = (User) redisCacheTemplate.opsForValue().get(key);
//        log.info("[对象缓存结果] - [{}]", user);

        //从
        redisUtil.set("name","haha");
        String name = redisUtil.get("name");
        log.info("[{}]",name);
        return k1;
    }
}
