package com.soft1851.ioc.config;

import com.soft1851.ioc.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/19
 * @Version 1.0
 */
@Configuration
public class AppConfig {

    @Bean
    public Student student(){
        return new Student();
    }
}
