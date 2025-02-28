package com.spring.mypersonalstay.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.spring.mypersonalstay.dto.member.ReqSignInDto;
import com.spring.mypersonalstay.entity.Member;
import com.spring.mypersonalstay.handler.CustomException;
import com.spring.mypersonalstay.handler.StatusCode;
import com.spring.mypersonalstay.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	private static final String SECRET_KEY = "SDS화이팅";
	private static final long EXPIRED_TIME = 8640000000L;
	
	public String getToken(ReqSignInDto reqSignInDto) {
		Member member = memberRepository.findByEmail(reqSignInDto.getEmail()).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		if (!member.getPassword().equals(reqSignInDto.getPassword())) throw new CustomException(StatusCode.INVALID_PASSWORD);
		
		return JWT.create()
				.withSubject(String.valueOf(member.getMemberId()))
				.withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRED_TIME))
				.sign(Algorithm.HMAC256(SECRET_KEY));
	}
}
