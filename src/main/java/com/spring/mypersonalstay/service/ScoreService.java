package com.spring.mypersonalstay.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.mypersonalstay.dto.ScoreReq;
import com.spring.mypersonalstay.dto.ScoreRes;
import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.entity.Score;
import com.spring.mypersonalstay.entity.Status;
import com.spring.mypersonalstay.exception.CustomException;
import com.spring.mypersonalstay.exception.StatusCode;
import com.spring.mypersonalstay.repository.GuestHouseRepository;
import com.spring.mypersonalstay.repository.ScoreRepository;
import com.spring.mypersonalstay.repository.StatusRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreService {
	private final ScoreRepository scoreRepository;
	private final GuestHouseRepository guestHouseRepository;
	private final StatusRepository statusRepository;

	public List<String> parseTags(String tags) {
		return Arrays.asList(tags.split(","));
	}

	public Integer getScoreWithTags(List<String> tags, String mbti) {
		return tags.stream().filter((t) -> mbti.equals(t)).toList().size();
	}

	@Transactional
	public ScoreRes findScore(Long id) {
		Score rScore = scoreRepository.findById(id).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));

		return new ScoreRes(rScore);
	}

	@Transactional
	public ScoreRes updateScore(ScoreReq scoreReq) {
		Score rScore = (Score) guestHouseRepository.findById(scoreReq.getGuestHouseId())
				.orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND)).getScores().stream()
				.filter(s -> s.getMbti().equals(scoreReq.getMbti()))
				.findFirst()
		        .orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));

		GuestHouse guestHouse = guestHouseRepository.findById(scoreReq.getGuestHouseId())
				.orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		List<Status> rStatusList = statusRepository.findByGuestHouse(guestHouse);
		int tmpScore = rStatusList.stream().filter((t) -> t.getMember().getMbti().equals(rScore.getMbti())).toList()
				.size();
		rScore.setTotalScore(rScore.getTotalScore() + tmpScore);

		return new ScoreRes(rScore);
	}

	@Transactional
	public ScoreRes initScore(ScoreReq scoreReq) {
		Score rScore = (Score) guestHouseRepository.findById(scoreReq.getGuestHouseId())
				.orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND)).getScores().stream()
				.filter(s -> s.getMbti().equals(scoreReq.getMbti()))
				.findFirst() // Optional<Score>로 변환
				.orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND)); // Score가 없으면 예외 발생

		String mbti = guestHouseRepository.findById(scoreReq.getGuestHouseId())
				.orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND)).getTags();
		rScore.setTotalScore((float) getScoreWithTags(parseTags(mbti), rScore.getMbti()));

		return new ScoreRes(rScore);
	}

}
