package com.spring.mypersonalstay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Member {
	@Id
	@Column(name="member_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberId;
	
	@Column(length = 100)
	private String name;
	
	private int age;
	
	@Column(length = 1)
	private String sex;
	
	@Column(length = 4)
	private String mbti;
	
	@Column(length = 100)
	private String introduce;
	
	@Column(length = 20)
	private String favorite;
	
	@Column(length = 20)
	private String alcohol_limit;
	
	@Column(length = 100)
	private String img_url;

	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", age=" + age + ", sex=" + sex + ", mbti=" + mbti
				+ ", introduce=" + introduce + ", favorite=" + favorite + ", alcohol_limit=" + alcohol_limit
				+ ", img_url=" + img_url + "]";
	}
	
}
