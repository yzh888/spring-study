package com.soft1851.spring.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/19
 * @Version 1.0
 */
@RestController
public class HelloController {
    @RequestMapping(value = "/hello")
    public String getHello() {
        return "hello";
    }
}
