package com.spring.mypersonalstay.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.spring.mypersonalstay.dto.member.ReqSignInDto;
import com.spring.mypersonalstay.entity.Member;
import com.spring.mypersonalstay.exception.CustomException;
import com.spring.mypersonalstay.exception.StatusCode;
import com.spring.mypersonalstay.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	private static final String SECRET_KEY = "SDS화이팅";
	private static final long EXPIRED_TIME = 8640000000L;

	public String getToken(ReqSignInDto reqSignInDto) {
		Member member = memberRepository.findByEmail(reqSignInDto.getEmail())
				.orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		if (!member.getPassword().equals(reqSignInDto.getPassword()))
			throw new CustomException(StatusCode.INVALID_PASSWORD);

		return JWT.create().withClaim("memberId", member.getMemberId()).withClaim("email", member.getEmail())
				.withClaim("name", member.getName()).withClaim("age", member.getAge()).withClaim("sex", member.getSex())
				.withClaim("mbti", member.getMbti()).withClaim("introduce", member.getIntroduce())
				.withClaim("favorite", member.getFavorite()).withClaim("alcoholLimit", member.getAlcoholLimit())
				.withClaim("imgUrl", member.getImgUrl()).withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRED_TIME)).sign(Algorithm.HMAC256(SECRET_KEY));

	}

}
