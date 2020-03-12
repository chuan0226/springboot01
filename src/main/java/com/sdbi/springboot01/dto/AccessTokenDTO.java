package com.sdbi.springboot01.dto;

import lombok.Data;

/**
 * @author chuan
 * @date 2020/2/25-23:00
 */
@Data
public class AccessTokenDTO {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;

}
