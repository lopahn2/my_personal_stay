package com.spring.mypersonalstay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.mypersonalstay.dto.member.ReqSignInDto;
import com.spring.mypersonalstay.dto.status.LikeReqDto;
import com.spring.mypersonalstay.service.MemberService;
import com.spring.mypersonalstay.service.StatusService;

@SpringBootApplication
public class Sp00TemaProjectApplication implements CommandLineRunner{

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private StatusService statusService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		 * ReqSignInDto reqSignInDto = ReqSignInDto.builder()
		 * .email("user1@example.com") .password("password123") .build();
		 * 
		 * System.out.println(memberService.getToken(reqSignInDto));
		 */
//		statusService.like(1L, 1L, new LikeReqDto(true));
//		statusService.getLikedGuestHouseList(1L);
//		statusService.getUsedGuestHouseList(1L);
	}

	public static void main(String[] args) {
		SpringApplication.run(Sp00TemaProjectApplication.class, args);
	}

}
 