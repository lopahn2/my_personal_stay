package com.spring.mypersonalstay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mypersonalstay.dto.member.ReqSignInDto;
import com.spring.mypersonalstay.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	final MemberService memberService;
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer ";
	
	// 로그인
	@PostMapping("/member/login")
	public ResponseEntity<?> login(@RequestBody ReqSignInDto req) throws Exception {
		return new ResponseEntity<>(memberService.getToken(req), HttpStatus.OK);
	}
	
	// 회원정보 가져오기
	@GetMapping("/member/info")
	public ResponseEntity<?> getMember(HttpServletRequest request) {
		String bearerToken = request.getHeader(AUTHORIZATION_HEADER);
		String token = "";
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(BEARER_PREFIX)) {
			token = bearerToken.substring(7);
		}
		return new ResponseEntity<>(memberService.getMember(token), HttpStatus.OK);
	}
}
