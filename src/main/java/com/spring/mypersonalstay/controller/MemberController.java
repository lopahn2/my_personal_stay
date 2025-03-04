package com.spring.mypersonalstay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mypersonalstay.dto.member.ReqSignInDto;
import com.spring.mypersonalstay.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	final MemberService memberService;
	
	// 로그인
	@PostMapping("/member/login")
	public ResponseEntity<?> login(@RequestBody ReqSignInDto req) throws Exception {
		return new ResponseEntity<>(memberService.getToken(req), HttpStatus.OK);
	}
}
