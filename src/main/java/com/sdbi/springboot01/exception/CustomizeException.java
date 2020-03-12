package com.sdbi.springboot01.exception;

/**
 * @author chuan
 * @date 2020/3/3-18:51
 */
public class CustomizeException extends RuntimeException{
    private String message;
    private Integer code;

    public CustomizeException(ICustomizeErrorCode errorCode){
        this.message=errorCode.getMessage();
        this.code=errorCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage(){
        return message;
    }
}
