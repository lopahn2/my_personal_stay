package com.spring.mypersonalstay.service;
// member 정보 받아오기?

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


import com.spring.mypersonalstay.dto.guestHouse.GuestHouseRes;
import com.spring.mypersonalstay.dto.member.ResMemberDto;
import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.entity.Member;
import com.spring.mypersonalstay.entity.Status;
import com.spring.mypersonalstay.exception.CustomException;
import com.spring.mypersonalstay.exception.StatusCode;
import com.spring.mypersonalstay.repository.GuestHouseRepository;
import com.spring.mypersonalstay.repository.StatusRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class GuestHouseService {
	private final GuestHouseRepository guestHouseRepository;
	private final StatusRepository statusRepository;
	
	// 1. 모든 게스트하우스 목록 제공
	public List<GuestHouseRes> getGuestHouse(){
		List<GuestHouse> list = guestHouseRepository.getAllGuestHousesScore();
		if(list == null || list.isEmpty())
			throw new CustomException(StatusCode.NOT_FOUND);
		return list.stream().map(GuestHouseRes::new).collect(Collectors.toList());
		
	}
	// 2. 특정 게스트하우스 목록 제공
	public GuestHouseRes getGuestHouse(Long id){
		GuestHouse guestHouse = guestHouseRepository.getGuestHouseScore(id).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		return new GuestHouseRes(guestHouse);
		
	}
	
	// 게하 등록한 사람 목록
	public List<ResMemberDto> getGuestHouseUsedMember(Long id) {
		GuestHouse guestHouse = guestHouseRepository.findById(id).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));

		return statusRepository.findByGuestHouse(guestHouse)
				.stream()
				.filter(s -> s.getIsBooked())
				.map(s -> s.getMember().toResMemberDto())
				.collect(Collectors.toList());
	}

	
	
}
