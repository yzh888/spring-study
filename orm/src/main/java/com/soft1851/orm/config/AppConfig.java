package com.soft1851.orm.config;

import com.soft1851.orm.dao.PostDao;
import com.soft1851.orm.dao.impl.PostDaoImpl;
import com.soft1851.orm.entity.Forum;
import com.soft1851.orm.entity.Post;
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
}
