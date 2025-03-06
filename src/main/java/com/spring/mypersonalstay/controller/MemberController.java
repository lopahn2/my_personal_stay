package com.spring.mypersonalstay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mypersonalstay.dto.member.ReqSignInDto;
import com.spring.mypersonalstay.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "사용자", description = "사용자 API")
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = { "*" }, maxAge = 6000)
public class MemberController {
	final MemberService memberService;

	// 로그인
	@PostMapping("/member/login")
	@Operation(summary = "로그인", description = "사용자가 이메일과 비밀번호로 로그인합니다.")
	public ResponseEntity<?> login(@RequestBody ReqSignInDto req) throws Exception {
		return new ResponseEntity<>(memberService.getToken(req), HttpStatus.OK);
	}

	// 회원 정보
	@GetMapping("/member/{id}")
	@Operation(summary = "정보 조회", description = "타 사용자 정보 조회")
	public ResponseEntity<?> login(@Parameter(required=true, description="멤버 고유번호")
	@PathVariable Long id) throws Exception {
		return new ResponseEntity<>(memberService.getMemberInfo(id), HttpStatus.OK);
	}
}
