package com.spring.mypersonalstay.dto;

import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.entity.Member;
import com.spring.mypersonalstay.entity.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StatusReq {
	private Long memberId;
	private Long guestHouseId;
	private Boolean isLiked;
	private Boolean isBooked;
	private Boolean isUsed;
	
	public Status toStatus(StatusReq statusReq) {
		return Status.builder()
				.member(Member.builder().memberId(statusReq.memberId).build())
				.guestHouse(GuestHouse.builder().guestHouseId(statusReq.guestHouseId).build())
				.isLiked(statusReq.isLiked)
				.isBooked(statusReq.isBooked)
				.isUsed(statusReq.isUsed)
				.build();
				
	}
}
