package com.study.mouse.common;

import lombok.*;

import java.util.Map;

@Getter
@ToString
public class ApiResponse<T> {

    private boolean status;

    private T data;

    private Map<String, Object> metaData;


    public ApiResponse(boolean status) {
        this.status = status;
    }

    public ApiResponse(boolean status, T data) {
        this.status = status;
        this.data = data;
    }

    public ApiResponse(boolean status, T data, Map<String, Object> metaData) {
        this.status = status;
        this.data = data;
        this.metaData = metaData;
    }

}
