package com.sdbi.springboot01.dto;

import lombok.Data;

/**
 * @author chuan
 * @date 2020/3/10-23:05
 */
@Data
public class QuestionQueryDTO {
    private String search;
    private String tag;
    private Integer page;
    private Integer size;
}
