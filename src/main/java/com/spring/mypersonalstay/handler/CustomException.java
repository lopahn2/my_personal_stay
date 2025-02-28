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
        super(authCode.getMessage()); // Exception 메시지로 설정
        this.authCode = authCode;
    }
}