package com.spring.mypersonalstay.dto;

import com.spring.mypersonalstay.entity.Score;

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
public class ScoreRes {
	private Long scoreId;
	private String mbti;
	private Float totalScore;
	
	public ScoreRes(Score score) {
		scoreId = score.getScoreId();
		mbti = score.getMbti();
		totalScore = score.getTotalScore();
	}
}
