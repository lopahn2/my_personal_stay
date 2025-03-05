package com.spring.mypersonalstay.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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

	@Override
	public String toString() {
		return "Score [scoreId=" + scoreId + ", mbti=" + mbti + ", totalScore=" + totalScore + "]";
	}
	
	
	
}
