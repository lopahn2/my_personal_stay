package com.spring.jpql;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.jpql.entity.Board;
import com.spring.jpql.entity.Custom;
import com.spring.jpql.entity.Role;
import com.spring.jpql.repository.BoardRepository;
import com.spring.jpql.repository.CustomRepository;
import com.spring.jpql.repository.RoleRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Sp04JpqlApplication implements CommandLineRunner {
	@Autowired
	private CustomRepository customRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private BoardRepository boardRepository;

	@Override
	@Transactional
	public void run(String... args) throws Exception {

//		boardRepository.getBoards().forEach(b -> {
//			System.out.println(b);
//			System.out.println(b.getCustom());
//		});
		// Role이 Admin인 권한을 가지는 사용자를 추가
//		Role adminRole = roleRepository.findById(2).get();
//		
//		Custom c = new Custom();
//		c.setName("DDD");
//		c.setPassword("ddd");
//		c.setEmail("ddd@google.com");
//		c.setRegDate(LocalDateTime.now());
//				
//		c.setRoles(Set.of(adminRole));
//		customRepository.save(c);
//		
//		
		// 관리자 권한을 가지는 4 (DDD) 번 고객이 게시글을 추가
//		Custom ddd = customRepository.findById(4).get();
//		Board board = new Board();
//		board.setTitle("공지");
//		board.setContent("다음주 월요일은 쉽니다");
//		board.setRegDate(LocalDateTime.now());
//		board.setCustom(ddd);
//		
//		boardRepository.save(board);
		Role adminRole = roleRepository.findById(2).get();
		boardRepository.getBoards(adminRole.getName()).forEach(b -> System.out.println(b));
	}
		

	public static void main(String[] args) {
		SpringApplication.run(Sp04JpqlApplication.class, args);
	}

}
