package com.spring.mypersonalstay.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mypersonalstay.dto.guestHouse.GuestHouseRes;
import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.service.GuestHouseService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Tag(name="게스트하우스", description="게스트하우스 API")
@RestController
@RequiredArgsConstructor
public class GuestHouseController {
	private final GuestHouseService guestHouseService;

	
	@GetMapping("/guesthouse")
	@Operation(summary="게스트하우스 전체조회", description="전체 게스트하우스 목록을 조회합니다.")
	public ResponseEntity<?> getAllGuestHouse() {
		return new ResponseEntity<>(guestHouseService.getGuestHouse(),HttpStatus.OK);
	}
	
	@GetMapping("/guesthouse/{id}")
	@Operation(summary="게스트하우스 조회", description="게스트하우스 하나를 조회합니다.")
	public ResponseEntity<?> getGuestHouse(
			@Parameter(required=true, description="게스트하우스 고유번호")
			@PathVariable Long id) {
		return new ResponseEntity<>(guestHouseService.getGuestHouse(id),HttpStatus.OK);
	}
	
	@GetMapping("/guesthouse/info/{id}")
	@Operation(summary="게스트하우스 멤버 조회", description="게스트하우스의 예약자 명단을 조회합니다.")
	public ResponseEntity<?> getGuestHouseUsedMember(
			@Parameter(required=true, description="게스트하우스 고유번호")
			@PathVariable Long id) {
		return new ResponseEntity<>(guestHouseService.getGuestHouseUsedMember(id),HttpStatus.OK);
	}
	
	
}
