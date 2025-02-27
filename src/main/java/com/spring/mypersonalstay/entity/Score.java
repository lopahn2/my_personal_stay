package com.spring.mypersonalstay.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
	@Column(name = "score_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scoreId;
	
	@Column(length = 4)
	private String mbti;
	
	@Column(name = "totalScore")
	private Float totalScore;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "guest_house_id")
	private GuestHouse guesthouse;
}
