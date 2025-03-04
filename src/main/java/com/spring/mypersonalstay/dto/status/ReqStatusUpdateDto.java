package com.spring.mypersonalstay.dto.status;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReqStatusUpdateDto {
	private Long memberId;
	private Long guestHouseId;
	private LikeReqDto likeReqDto;
	private BookReqDto bookReqDto;
	private UsedReqDto usedReqDto;
}
