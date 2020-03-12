package com.sdbi.springboot01.dto;

import lombok.Data;

/**
 * @author chuan
 * @date 2020/2/25-23:40
 */
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatar_url;

}
