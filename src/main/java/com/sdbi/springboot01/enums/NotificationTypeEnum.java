package com.sdbi.springboot01.enums;

/**
 * @author chuan
 * @date 2020/3/8-21:55
 */
public enum NotificationTypeEnum {
    REOLY_QUESTION(1,"回复了问题"),
    REOLY_COMMENT(2,"回复了评论")
    ;
    private int type;
    private String name;

    public int getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    NotificationTypeEnum(int status, String name){
        this.type =status;
        this.name=name;
    }
    public static String nameOfType(int type) {
        for (NotificationTypeEnum notificationTypeEnum : NotificationTypeEnum.values()) {
            if (notificationTypeEnum.getType() == type) {
                return notificationTypeEnum.getName();
            }
        }
        return "";
    }
}
