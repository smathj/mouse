package com.study.mouse.common.handler;


import com.study.mouse.common.ApiResponse;
import com.study.mouse.common.exception.FileException;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(FileException.class)
    public ApiResponse<?> exception1(FileException fileException) {

        HashMap<String, Object> metaData = new HashMap<>();

        metaData.put("message", fileException.getMessage());

        return new ApiResponse(false, null, metaData);
    }


}
