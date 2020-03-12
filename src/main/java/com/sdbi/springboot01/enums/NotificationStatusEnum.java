package com.sdbi.springboot01.enums;

/**
 * @author chuan
 * @date 2020/3/8-22:03
 */
public enum NotificationStatusEnum {
    UNREAD(0),READ(1);
    private int status;

    public int getStatus() {
        return status;
    }

    NotificationStatusEnum(int status){
        this.status=status;
    }
}
