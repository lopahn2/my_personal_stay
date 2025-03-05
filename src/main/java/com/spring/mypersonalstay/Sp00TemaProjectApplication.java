package com.spring.mypersonalstay;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.mypersonalstay.dto.ScoreReq;
import com.spring.mypersonalstay.dto.ScoreRes;
import com.spring.mypersonalstay.dto.member.ReqSignInDto;
import com.spring.mypersonalstay.exception.CustomException;
import com.spring.mypersonalstay.service.MemberService;
import com.spring.mypersonalstay.service.ScoreService;

@SpringBootApplication
public class Sp00TemaProjectApplication {


	public static void main(String[] args) {
		SpringApplication.run(Sp00TemaProjectApplication.class, args);
	}

}
