package com.sdbi.springboot01.dto;

import com.sdbi.springboot01.model.User;
import lombok.Data;

/**
 * @author chuan
 * @date 2020/3/5-15:35
 */
@Data
public class CommentDTO {
    private Long id;
    private Long parentId;
    private Integer type;
    private Long commentator;
    private Long gmtCreate;
    private Long gmtModified;
    private Long likeCount;
    private String content;
    private User user;
    private Integer commentCount;
}
