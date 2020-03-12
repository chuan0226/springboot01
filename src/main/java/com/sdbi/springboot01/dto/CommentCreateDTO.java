package com.sdbi.springboot01.dto;

import lombok.Data;

/**
 * @author chuan
 * @date 2020/3/4-0:28
 */
@Data
public class CommentCreateDTO {
    private Long parentId;
    private String content;
    private Integer type;
}
