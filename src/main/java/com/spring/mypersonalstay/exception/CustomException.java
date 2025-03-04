package com.spring.mypersonalstay.exception;

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
    	super(authCode.getMessage());
        this.authCode = authCode;
    }
}