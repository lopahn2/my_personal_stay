package com.spring.mypersonalstay.dto.guestHouse;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.spring.mypersonalstay.dto.ScoreRes;
import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.entity.Score;

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
public class GuestHouseRes { 
	private Long guestHouseId;
	private String name;
	private String location;
	private int capacity;
	private String description;
	private String tags;
	private String bgImgUrl;
	private LocalDateTime regDate; //regDate는 string으로 변환
	private List<ScoreRes> scores; // List로 받아야하나?
	
	public GuestHouseRes (GuestHouse guestHouse) {
        guestHouseId = guestHouse.getGuestHouseId();
        name = guestHouse.getName();
        location = guestHouse.getLocation();
        capacity = guestHouse.getCapacity();
        description = guestHouse.getDescription();
        tags = guestHouse.getTags();
        bgImgUrl = guestHouse.getBgImgUrl();
        regDate = guestHouse.getRegDate();
        scores = guestHouse.getScores().stream()
                .map(ScoreRes::new)
                .collect(Collectors.toList());
   }
	
//	public GuestHouseRes toGuestHouseRes(GuestHouse guestHouse){
//	       return GuestHouseRes.builder()
//	               .guestHouseId(guestHouse.getGuestHouseId())
//	               .name(guestHouse.getName())
//	               .location(guestHouse.getLocation())
//	               .capacity(guestHouse.getCapacity())
//	               .description(guestHouse.getDescription())
//	               .tags(guestHouse.getTags())
//	               .bgImgUrl(guestHouse.getBgImgUrl())
//	               .regDate(guestHouse.getRegDate().toString())
//	               .scores(guestHouse.getScores())//임시로 score list로 넘김, 이후 dto형태로 변경 필요.
//	               .build();
//	               
//	   }
}
