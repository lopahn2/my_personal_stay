package com.spring.mypersonalstay;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.spring.mypersonalstay.dto.ScoreReq;
import com.spring.mypersonalstay.service.ScoreService;

@SpringBootApplication
public class Sp00TemaProjectApplication {
	public static void main(String[] args) {
		SpringApplication.run(Sp00TemaProjectApplication.class, args);
		
	}
	//초기 Score값 초기화
//	@Bean
//    public CommandLineRunner initScores(ScoreService scoreService) {
//        return args -> {
//            // 16가지 MBTI 유형 배열
//            String[] mbtiTypes = {
//                "INTP", "INTJ", "INFP", "INFJ",
//                "ISTP", "ISTJ", "ISFP", "ISFJ",
//                "ENTP", "ENTJ", "ENFP", "ENFJ",
//                "ESTP", "ESTJ", "ESFP", "ESFJ"
//            };
//
//            // guestHouseId가 1부터 20까지
//            for (long guestHouseId = 1; guestHouseId <= 20; guestHouseId++) {
//                for (String mbti : mbtiTypes) {
//                    ScoreReq scoreReq = new ScoreReq(mbti, guestHouseId);
//                    try {
//                        // score 등록 (initScore 호출)
//                        scoreService.initScore(scoreReq);
//                        // score 업데이트 (updateScore 호출)
//                        scoreService.updateScore(scoreReq);
//                        System.out.println("Success for guestHouseId: " + guestHouseId + ", MBTI: " + mbti);
//                    } catch (Exception e) {
//                        System.out.println("Failed for guestHouseId: " + guestHouseId + ", MBTI: " + mbti 
//                                + " - " + e.getMessage());
//                    }
//                }
//            }
//        };
//	}
}
