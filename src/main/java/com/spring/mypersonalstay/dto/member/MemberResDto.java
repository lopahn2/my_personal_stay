package com.spring.mypersonalstay.dto.member;

import com.spring.mypersonalstay.entity.Member;

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
public class MemberResDto {
	private Long memberId;
	private String email;
	private String name;
	private int age;
	private String sex;
	private String mbti;
	private String introduce;
	private String favorite;
	private String alcoholLimit;
	private String imgUrl;
	
	public MemberResDto(Member member) {
		memberId = member.getMemberId();
		email = member.getEmail();
		name = member.getName();
		age = member.getAge();
		sex = member.getSex().equals("M")?"남자":"여자";
		mbti = member.getMbti();
		introduce = member.getIntroduce();
		favorite = member.getFavorite();
		alcoholLimit = member.getAlcoholLimit();
		imgUrl = member.getImgUrl();
	}
}
