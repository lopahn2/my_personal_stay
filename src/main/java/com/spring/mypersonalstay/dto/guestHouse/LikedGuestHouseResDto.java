package com.spring.mypersonalstay.dto.guestHouse;

import java.time.LocalDateTime;

import com.spring.mypersonalstay.entity.GuestHouse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class LikedGuestHouseResDto {
	private Long guestHouseId;
	private String name;
	private String location;
	private int capacity;
	private String description;
	private String tags;
	private String bgImgUrl;
	private String hostImgUrl;
	private LocalDateTime regDate;
//	private List<Score> scores;
	
	public LikedGuestHouseResDto(GuestHouse guestHouse) {
		guestHouseId = guestHouse.getGuestHouseId();
		name = guestHouse.getName();
		location = guestHouse.getLocation();
		capacity = guestHouse.getCapacity();
		description = guestHouse.getDescription();
		tags = guestHouse.getTags();
		bgImgUrl = guestHouse.getBgImgUrl();
		hostImgUrl = guestHouse.getHostImgUrl();
		regDate = guestHouse.getRegDate();
	}
}
