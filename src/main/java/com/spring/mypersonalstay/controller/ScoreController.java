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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@Tag(name = "Score Controller", description = "Score CRU 기능 수행 컨트롤러")
public class ScoreController {
	final ScoreService scoreService;
	// Id 로 Score 조회
	@Operation(summary = "Score Search By Parameter", description = "Score 정보를 Score의 PK ID로 조회합니다.")
	@GetMapping("/scores/{id}")
    public ResponseEntity<?> findScore(@PathVariable Long id) throws Exception{
        return new ResponseEntity<>(scoreService.findScore(id),HttpStatus.OK);
    }
		
	//scoreReq로 score 업데이트. 
	@Operation(summary = "Score Update By Body Contents", description = "Score 정보를 ScoreReq의 값들로 업데이트합니다.")
	@PutMapping("/scores/update")
    public ResponseEntity<?> updateScore(@RequestBody ScoreReq scoreReq) throws Exception{
        return new ResponseEntity<>(scoreService.updateScore(scoreReq),HttpStatus.OK);
    }
	//scoreReq로 score 등록.
	@Operation(summary = "Score Register By Body Contents", description = "Score 정보를 ScoreReq의 값들로 등록합니다.")
	@PostMapping("/scores/init")
	public ResponseEntity<?> initScore(@RequestBody ScoreReq scoreReq) throws Exception {
		return new ResponseEntity<>(scoreService.initScore(scoreReq),HttpStatus.OK);
	}
	
		
}

