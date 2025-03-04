package com.spring.mypersonalstay.service;
// member 정보 받아오기?

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.spring.mypersonalstay.dto.guestHouse.GuestHouseRes;
import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.exception.CustomException;
import com.spring.mypersonalstay.exception.StatusCode;
import com.spring.mypersonalstay.repository.GuestHouseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class GuestHouseService {
	private final GuestHouseRepository guestHouseRepository;
	
	// 1. 모든 게스트하우스 목록 제공
	public List<GuestHouseRes> getGuestHouse() throws CustomException{
		List<GuestHouse> list = guestHouseRepository.getAllGuestHousesScore();
		if(list == null || list.isEmpty())
			throw new CustomException(null);
		return list.stream().map(GuestHouseRes::new).collect(Collectors.toList());
		
	}
	// 2. 특정 게스트하우스 목록 제공
	public GuestHouseRes getGuestHouse(Long id) throws CustomException{
		GuestHouse guestHouse = guestHouseRepository.getGuestHouseScore(id).orElseThrow(() -> new CustomException(null));

		return new GuestHouseRes(guestHouse);
		
	}
	
	
	
}
