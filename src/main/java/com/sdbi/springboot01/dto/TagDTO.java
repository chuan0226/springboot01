package com.sdbi.springboot01.dto;

import lombok.Data;

import java.util.List;

/**
 * @author chuan
 * @date 2020/3/7-1:09
 */
@Data
public class TagDTO {
    private String categoryName;
    private List<String> tags;
}
