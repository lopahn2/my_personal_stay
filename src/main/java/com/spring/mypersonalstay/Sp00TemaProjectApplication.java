package com.spring.mypersonalstay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.mypersonalstay.dto.member.ReqSignInDto;
import com.spring.mypersonalstay.service.MemberService;

@SpringBootApplication
public class Sp00TemaProjectApplication implements CommandLineRunner{

	@Autowired
	private MemberService memberService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		ReqSignInDto reqSignInDto = ReqSignInDto.builder()
										.email("user1@example.com")
										.password("password123")
										.build();
		
		System.out.println(memberService.getToken(reqSignInDto));
		
	}

	public static void main(String[] args) {
		SpringApplication.run(Sp00TemaProjectApplication.class, args);
	}

}
 