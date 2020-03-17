package com.soft1851.ioc.config;

import com.soft1851.ioc.dao.ForumDao;
import com.soft1851.ioc.dao.Impl.ForumDaoImpl;
import com.soft1851.ioc.dao.Impl.PostDaoImpl;
import com.soft1851.ioc.dao.PostDao;
import com.soft1851.ioc.entity.Forum;
import com.soft1851.ioc.entity.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/17
 * @Version 1.0
 */
@Configuration
public class AppConfig {
    @Bean
    public Forum forum() {
        return new Forum();
    }

    @Bean
    public ForumDao forumDao() {
        return new ForumDaoImpl();
    }

    @Bean
    public PostDao postDao(){
        return new PostDaoImpl();
    }

    @Bean
    public Post post(){
        return new Post();
    }
}
