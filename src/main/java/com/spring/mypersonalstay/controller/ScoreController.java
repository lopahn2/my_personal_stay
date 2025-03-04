package com.spring.mypersonalstay.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.spring.mypersonalstay.dto.ScoreReq;
import com.spring.mypersonalstay.service.ScoreService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
public class ScoreController {
	final ScoreService scoreService;
	// Id 로 Score 조회
	@GetMapping("/scores/{id}")
    public ResponseEntity<?> findScore(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(scoreService.findScore(id),HttpStatus.OK);
    }
		
	//scoreReq로 score 업데이트. 
	@PutMapping("/scores/update")
    public ResponseEntity<?> updateScore(@RequestBody ScoreReq scoreReq) throws Exception{
        return new ResponseEntity<>(scoreService.updateScore(scoreReq),HttpStatus.OK);
    }
	//scoreReq로 score 등록.
	@PostMapping("/scores/init")
	public ResponseEntity<?> initScore(@RequestBody ScoreReq scoreReq) throws Exception {
		return new ResponseEntity<>(scoreService.initScore(scoreReq),HttpStatus.OK);
	}
	
		
}

