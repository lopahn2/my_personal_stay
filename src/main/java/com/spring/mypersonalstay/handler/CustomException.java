package com.spring.mypersonalstay.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@AllArgsConstructor
//@Getter
//public class CustomException extends RuntimeException{
//    StatusCode authCode;
//    
//}

@Getter
public class CustomException extends RuntimeException {
    private StatusCode authCode;

    public CustomException(StatusCode authCode) {
        this.authCode = authCode;
    }
}