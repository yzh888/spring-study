package com.soft1851.ioc.entity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/17
 * @Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class ForumTest {
    @Autowired
    private Forum forum;
    @Test
    public void test(){
        forum.setForumId(1);
        forum.setForumName("老颜");
        System.out.println(forum);
    }
}