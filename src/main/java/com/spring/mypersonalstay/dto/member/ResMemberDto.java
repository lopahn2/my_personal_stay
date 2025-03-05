package com.spring.mypersonalstay.dto.member;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
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
public class ResMemberDto {

	private String email;

	private String password;

	private String name;

	private int age;

	private String sex;

	private String mbti;

	private String introduce;

	private String favorite;

	private String alcoholLimit;

	private String imgUrl;

	private LocalDateTime regDate;
}
