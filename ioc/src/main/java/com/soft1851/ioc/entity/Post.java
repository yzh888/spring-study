package com.soft1851.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/17
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post implements Serializable {
    private Integer postId;
    private Integer forumId;
    private String title;
    private String content;
    private byte[] thumbnail;
    private Timestamp postTime;
}
