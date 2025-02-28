package com.spring.mypersonalstay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mypersonalstay.dto.StatusReq;
import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.entity.Member;
import com.spring.mypersonalstay.entity.Status;
import com.spring.mypersonalstay.repository.GuestHouseRepository;
import com.spring.mypersonalstay.repository.MemberRepository;
import com.spring.mypersonalstay.repository.StatusRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatusService {
	@Autowired
	private StatusRepository statusRepository;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private GuestHouseRepository guestHouseRepository;
	
	// 좋아요 누르기 & 취소하기
	@Transactional
	public Status like(StatusReq statusReq) throws Exception {
		System.out.println("statusReq=" + statusReq);
		Long memberId = statusReq.getMemberId();
		Member member = memberRepository.findById(memberId).orElseThrow(() -> new Exception("사용자 정보가 없습니다."));
		Long guestHouseId = statusReq.getGuestHouseId();
		GuestHouse guestHouse = guestHouseRepository.findById(guestHouseId).orElseThrow(() -> new Exception("게스트하우스 정보가 없습니다."));
		List<Status> statusList = statusRepository.findByMemberAndGuestHouse(member, guestHouse);
		if (statusList == null || statusList.isEmpty()) {
			throw new Exception("사용자와 게스트하우스의 상태 정보가 없습니다.");
		}
		Status status = statusList.get(0);
		System.out.println("[before] status=" + status);
		status.setIsLiked(statusReq.getIsLiked()); // true:좋아요, false:좋아요취소
		System.out.println("[after] status=" + status);
		System.out.println("== 좋아요 누름 ==");
		return status;
	}
	
	// 예약하기 & 취소하기
	// 이용완료 처리하기
	// 좋아요 누른 게하 목록 가져오기
	// 이용완료한 게하 목록 가져오기
	// 같이 신청한 사용자 목록 가져오기
}
