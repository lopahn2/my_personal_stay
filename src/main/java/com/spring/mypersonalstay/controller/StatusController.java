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

import com.spring.mypersonalstay.dto.guestHouse.BookedGuestHouseResDto;
import com.spring.mypersonalstay.dto.guestHouse.LikedGuestHouseResDto;
import com.spring.mypersonalstay.dto.guestHouse.UsedGuestHouseResDto;
import com.spring.mypersonalstay.dto.status.LikeReqDto;
import com.spring.mypersonalstay.dto.status.ReqStatusUpdateDto;
import com.spring.mypersonalstay.entity.Status;
import com.spring.mypersonalstay.service.StatusService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@RestController
@RequiredArgsConstructor
@Tag(name = "상태", description = "즐겨찾기 / 예약 / 이전 사용 내역 들의 상태 관리 컨트롤러")
public class StatusController {

	final StatusService statusService;

	// 좋아요 누르기 & 취소하기
	@Operation(summary = "Like Status Update By Body Content", description = "게스트하우스를 사용자의 즐겨찾기 목록에 추가합니다.")
	@PostMapping("/status/like")
	public ResponseEntity<?> modifyLike(@RequestBody ReqStatusUpdateDto reqStatusUpdateDto) throws Exception {
		statusService.like(reqStatusUpdateDto.getMemberId(), reqStatusUpdateDto.getGuestHouseId(),
				reqStatusUpdateDto.getLikeReqDto());
		return ResponseEntity.status(HttpStatus.CREATED).body("좋아요 처리 완료");
	}

	@Operation(summary = "Book Status Update By Body Content", description = "게스트하우스를 사용자의 예약 목록에 추가합니다.")
	@PostMapping("/status/book")
	public ResponseEntity<?> modifyBook(@RequestBody ReqStatusUpdateDto reqStatusUpdateDto) throws Exception {
		statusService.book(reqStatusUpdateDto.getMemberId(), reqStatusUpdateDto.getGuestHouseId(),
				reqStatusUpdateDto.getBookReqDto());
		return ResponseEntity.status(HttpStatus.CREATED).body("예약 처리 완료");
	}

	@Operation(summary = "Used Status Update By Body Content", description = "게스트하우스를 사용자의 이전 사용 내역 목록에 추가합니다.")
	@PostMapping("/status/used")
	public ResponseEntity<?> modifyUsed(@RequestBody ReqStatusUpdateDto reqStatusUpdateDto) throws Exception {
		statusService.used(reqStatusUpdateDto.getMemberId(), reqStatusUpdateDto.getGuestHouseId(),
				reqStatusUpdateDto.getUsedReqDto());
		return ResponseEntity.status(HttpStatus.CREATED).body("이용 처리 완료");
	}

	@GetMapping("/status/like/{id}")
	@Operation(summary = "좋아요한 게스트하우스 목록 조회", description = "사용자가 좋아요를 누른 게스트하우스 전체 목록을 조회합니다.")
	public ResponseEntity<?> getLikedGuestHouseList(
			@Parameter(required = true, description = "사용자 고유번호") @PathVariable Long id) throws Exception {

		List<LikedGuestHouseResDto> likeGuestHouseResDto = statusService.getLikedGuestHouseList(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(likeGuestHouseResDto);
	}

	@GetMapping("/status/used/{id}")
	@Operation(summary = "이용완료한 게스트하우스 목록 조회", description = "사용자가 이용완료한 게스트하우스 전체 목록을 조회합니다.")
	public ResponseEntity<?> getUsedGuestHouseList(
			@Parameter(required = true, description = "사용자 고유번호") @PathVariable Long id) throws Exception {

		List<UsedGuestHouseResDto> usedGuestHouseResDto = statusService.getUsedGuestHouseList(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(usedGuestHouseResDto);
	}
	
	@GetMapping("/status/booked/{id}")
	@Operation(summary = "예약중인 게스트하우스 목록 조회", description = "사용자가 예약중인 게스트하우스 전체 목록을 조회합니다.")
	public ResponseEntity<?> getBookedGuestHouseList(
			@Parameter(required = true, description = "사용자 고유번호") @PathVariable Long id) throws Exception {

		List<BookedGuestHouseResDto> bookedGuestHouseResDto = statusService.getBookedGuestHouseList(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(bookedGuestHouseResDto);
	}

}
