package com.spring.mypersonalstay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class Score {
	@Id
	@Column(length = 4)
	private String mbti;
	
	@Column(name = "totalScore")
	private Float totalScore;
	
	//private GuestHouse guesthouse
}
