package com.spring.mypersonalstay.handler;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum StatusCode {
    OK(200, "요청을 성공적으로 처리했습니다.", HttpStatus.OK),
    CREATED(201, "회원가입이 필요합니다.", HttpStatus.CREATED),
    USERNAME_NOT_FOUND(404, "가입된 이메일이 없습니다.", HttpStatus.NOT_FOUND),
    INVALID_PASSWORD (400, "비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST),
    UNAUTHORIZED (400, "로그인 후 이용가능합니다.", HttpStatus.UNAUTHORIZED),
    NOT_FOUND(404, "일치하는 정보가 없습니다.", HttpStatus.NOT_FOUND),
    FAILED_REQUEST(400, "요청에 실패하였습니다.", HttpStatus.BAD_REQUEST),
    ;
    @Getter
    private int statusCode;
    @Getter
    private String message;
    @Getter
    private HttpStatus status;

    StatusCode(int statusCode, String message, HttpStatus status) {
        this.statusCode = statusCode;
        this.message = message;
        this.status = status;
    }

    public String toString() {
        return "{" +
                "\"code\" : " + "\""+ statusCode +"\"" +
                "\"status\" : " + "\""+status+"\"" +
                "\"message\" : " + "\""+message+"\"" +
                "}";
    }
}