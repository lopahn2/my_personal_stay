package com.spring.mypersonalstay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.mypersonalstay.dto.StatusReq;
import com.spring.mypersonalstay.service.StatusService;

@SpringBootApplication
public class Sp00TemaProjectApplication implements CommandLineRunner{
	
	@Autowired
	private StatusService statusService;

	public static void main(String[] args) {
		SpringApplication.run(Sp00TemaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		statusService.like(new StatusReq(1L,1L,true,false,false));
	}

}
 