package com.sdbi.springboot01.dto;

import com.sdbi.springboot01.model.User;
import lombok.Data;

/**
 * @author chuan
 * @date 2020/2/28-20:59
 */
@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private String description;
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Long creator;
    private Integer viewCount;
    private Integer commentCount;
    private Integer likeCount;
    private User user;
}
