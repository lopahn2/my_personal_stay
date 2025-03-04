package com.spring.mypersonalstay.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mypersonalstay.dto.guestHouse.LikedGuestHouseResDto;
import com.spring.mypersonalstay.dto.guestHouse.UsedGuestHouseResDto;
import com.spring.mypersonalstay.dto.status.LikeReqDto;
import com.spring.mypersonalstay.dto.status.ReqStatusUpdateDto;
import com.spring.mypersonalstay.entity.Status;
import com.spring.mypersonalstay.exception.ScoreSearchNotException;
import com.spring.mypersonalstay.service.StatusService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequiredArgsConstructor
public class StatusController {
	
	final StatusService statusService;

	// 좋아요 누르기 & 취소하기
	@PostMapping("/status/like")
	public ResponseEntity<?> modifyLike(@RequestBody ReqStatusUpdateDto reqStatusUpdateDto) throws Exception {		
		statusService.like(reqStatusUpdateDto.getMemberId(), reqStatusUpdateDto.getGuestHouseId(), reqStatusUpdateDto.getLikeReqDto());
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body("좋아요 처리 완료");
	}
	
	@PostMapping("/status/book")
	public ResponseEntity<?> modifyBook(@RequestBody ReqStatusUpdateDto reqStatusUpdateDto) throws Exception {
		statusService.book(reqStatusUpdateDto.getMemberId(), reqStatusUpdateDto.getGuestHouseId(), reqStatusUpdateDto.getBookReqDto());
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body("예약 처리 완료");
	}
	
	@PostMapping("/status/used")
	public ResponseEntity<?> modifyUsed(@RequestBody ReqStatusUpdateDto reqStatusUpdateDto) throws Exception {
		statusService.used(reqStatusUpdateDto.getMemberId(), reqStatusUpdateDto.getGuestHouseId(), reqStatusUpdateDto.getUsedReqDto());
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body("이용 처리 완료");
	}
	
	@GetMapping("/status/like/{id}")
	public ResponseEntity<?> getLikedGuestHouseList(@PathVariable Long id) throws Exception{
		List<LikedGuestHouseResDto> likeGuestHouseResDto = statusService.getLikedGuestHouseList(id);
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(likeGuestHouseResDto);
	}
	
	@GetMapping("/status/used/{id}")
	public ResponseEntity<?> getUsedGuestHouseList(@PathVariable Long id) throws Exception{
		List<UsedGuestHouseResDto> usedGuestHouseResDto = statusService.getUsedGuestHouseList(id);
		return ResponseEntity
				.status(HttpStatus.ACCEPTED)
				.body(usedGuestHouseResDto);
	}
	
}
