package com.spring.mypersonalstay.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mypersonalstay.dto.guestHouse.GuestHouseRes;
import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.service.GuestHouseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GuestHouseController {
	private final GuestHouseService guestHouseService;

	
	@GetMapping("/guesthouse")
	public List<GuestHouseRes> getAllGuestHouse() {
		return guestHouseService.getGuestHouse();
	}
	
	@GetMapping("/guesthouse/{id}")
	public GuestHouseRes getGuestHouse(@PathVariable Long id) {
		return guestHouseService.getGuestHouse(id);
	}
	
//	@GetMapping("/guesthouse/{mbti_score}")
//	public List<GuestHouse> findHouseByScore(@PathVariable Integer mbti_score) {
//		List<GuestHouse> houses = null;
//		
//		return houses;
//	}
	
}
