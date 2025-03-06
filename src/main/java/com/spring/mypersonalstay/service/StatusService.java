package com.spring.mypersonalstay.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mypersonalstay.dto.guestHouse.BookedGuestHouseResDto;
import com.spring.mypersonalstay.dto.guestHouse.LikedGuestHouseResDto;
import com.spring.mypersonalstay.dto.guestHouse.UsedGuestHouseResDto;
import com.spring.mypersonalstay.dto.status.BookReqDto;
import com.spring.mypersonalstay.dto.status.LikeReqDto;
import com.spring.mypersonalstay.dto.status.UsedReqDto;
import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.entity.Member;
import com.spring.mypersonalstay.entity.Status;
import com.spring.mypersonalstay.exception.CustomException;
import com.spring.mypersonalstay.exception.StatusCode;
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
	public Status like(Long memberId, Long guestHouseId, LikeReqDto likeReqDto) {
		Member member = memberRepository.findById(memberId).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		GuestHouse guestHouse = guestHouseRepository.findById(guestHouseId).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		List<Status> statusList = statusRepository.findByMemberAndGuestHouse(member, guestHouse);
		if (statusList == null || statusList.isEmpty()) {
			throw new CustomException(StatusCode.NOT_FOUND);
		}
		Status status = statusList.get(0);
		System.out.println("[before] like status=" + status);
		status.setIsLiked(likeReqDto.getFlag()); // true:좋아요, false:좋아요취소
		System.out.println("[after] like status=" + status);
		System.out.println("== 좋아요 처리 완료 ==");
		return status;
	}
	
	// 예약하기 & 취소하기
	@Transactional
	public Status book(Long memberId, Long guestHouseId, BookReqDto bookReqDto) {
		Member member = memberRepository.findById(memberId).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		GuestHouse guestHouse = guestHouseRepository.findById(guestHouseId).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		List<Status> statusList = statusRepository.findByMemberAndGuestHouse(member, guestHouse);
		if (statusList == null || statusList.isEmpty()) {
			throw new CustomException(StatusCode.NOT_FOUND);
		}
		Status status = statusList.get(0);
		System.out.println("[before] book status=" + status);
		status.setIsLiked(bookReqDto.getFlag()); // true:예약, false:예약취소
		System.out.println("[after] book status=" + status);
		System.out.println("== 예약 처리 완료 ==");
		return status;
	}
	
	// 이용완료 처리하기
	@Transactional
	public Status used(Long memberId, Long guestHouseId, UsedReqDto usedReqDto)  {
		Member member = memberRepository.findById(memberId).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		GuestHouse guestHouse = guestHouseRepository.findById(guestHouseId).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		List<Status> statusList = statusRepository.findByMemberAndGuestHouse(member, guestHouse);
		if (statusList == null || statusList.isEmpty()) {
			throw new CustomException(StatusCode.NOT_FOUND);
		}
		Status status = statusList.get(0);
		System.out.println("[before] used status=" + status);
		status.setIsLiked(usedReqDto.getFlag()); // true:이용완료, false:이용완료취소
		System.out.println("[after] used status=" + status);
		System.out.println("== 이용완료 처리 완료 ==");
		return status;
	}
	
	// 좋아요 누른 게하 목록 가져오기
	public List<LikedGuestHouseResDto> getLikedGuestHouseList(Long memberId)  {
		Member member = memberRepository.findById(memberId).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		List<Status> statusList = statusRepository.findByMemberAndIsLiked(member, true);
		if (statusList == null || statusList.isEmpty()) {
			throw new CustomException(StatusCode.NOT_FOUND);
		}
		List<LikedGuestHouseResDto> res = statusList.stream().map(o->new LikedGuestHouseResDto(o.getGuestHouse())).collect(Collectors.toList());
		System.out.println("좋아요 누른 게스트하우스 " + res.size() + "개");
		System.out.println(res);
		return res;
	}
	
	// 이용완료한 게하 목록 가져오기
	public List<UsedGuestHouseResDto> getUsedGuestHouseList(Long memberId)  {
		Member member = memberRepository.findById(memberId).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		List<Status> statusList = statusRepository.findByMemberAndIsUsed(member, true);
		if (statusList == null || statusList.isEmpty()) {
			throw new CustomException(StatusCode.NOT_FOUND);
		}
		List<UsedGuestHouseResDto> res = statusList.stream().map(o->new UsedGuestHouseResDto(o.getGuestHouse())).collect(Collectors.toList());
		System.out.println("이용완료한 게스트하우스 " + res.size() + "개");
		System.out.println(res);
		return res;
	}
	// 예약중인 게하 목록 가져오기
	public List<BookedGuestHouseResDto> getBookedGuestHouseList(Long memberId)  {
		Member member = memberRepository.findById(memberId).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		List<Status> statusList = statusRepository.findByMemberAndIsBooked(member, true);
		if (statusList == null || statusList.isEmpty()) {
			throw new CustomException(StatusCode.NOT_FOUND);
		}
		List<BookedGuestHouseResDto> res = statusList.stream().map(o->new BookedGuestHouseResDto(o.getGuestHouse())).collect(Collectors.toList());
		System.out.println("예약중인 게스트하우스 " + res.size() + "개");
		System.out.println(res);
		return res;
	}
	
}
