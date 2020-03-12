package com.sdbi.springboot01.dto;

import com.sdbi.springboot01.model.User;
import lombok.Data;

/**
 * @author chuan
 * @date 2020/3/8-22:32
 */
@Data
public class NotificationDTO {
    private Long id;
    private Long gmtCreate;
    private Integer status;
    private Long notifier;
    private String notifierName;
    private String outerTitle;
    private Long outerid;
    private String typeName;
    private Integer type;
}
