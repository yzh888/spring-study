package com.soft1851.ioc.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/17
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/beans.xml")
public class UserLoginDemo {
    @Autowired
    private UserLogin userLogin;
    @Autowired
    private User user;

    @Test
    public void test() {
        user.setPassword("1234");
        user.setAccount("admin");
        if (userLogin.userLogin(user)) {
            System.out.println("登录成功");
        }else {
            System.out.println("账号密码错误");
        }
    }
}