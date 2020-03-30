package com.soft1851.spring.web.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/24
 * @Version 1.0
 */
@Data
@Builder
public class Book {
    private String name;
    private Double price;
}
