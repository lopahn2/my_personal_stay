package com.spring.mypersonalstay.service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.mypersonalstay.dto.ScoreReq;
import com.spring.mypersonalstay.dto.ScoreRes;
import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.entity.Score;
import com.spring.mypersonalstay.entity.Status;
import com.spring.mypersonalstay.exception.ScoreSearchNotException;
import com.spring.mypersonalstay.repository.GuestHouseRepository;
import com.spring.mypersonalstay.repository.ScoreRepository;
import com.spring.mypersonalstay.repository.StatusRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreService {
	private final ScoreRepository scoreRepository;
	private final GuestHouseRepository guesetHouseRepository;
	private final StatusRepository statusRepository;
	
	
	public List<String> parseTags(String tags) {
		return Arrays.asList(tags.split(","));
	}
	
	public Integer getScoreWithTags(List<String> tags, String mbti) {
		return tags.stream().filter((t) -> mbti.equals(t)).toList().size();
	}
	
	@Transactional
	public ScoreRes findScore(Long id) throws Exception{
		Score rScore = scoreRepository.findById(id)
				.orElseThrow(()->
				new ScoreSearchNotException("해당 점수가 없습니다.")); 
		
		return new ScoreRes(rScore); 
	}
	
	@Transactional
	public ScoreRes updateScore(ScoreReq scoreReq) throws Exception {
		Score rScore = scoreRepository.findByGuestHouseIdAndMbti(scoreReq.getGuestHouseId(), scoreReq.getMbti()).get();	
		GuestHouse guestHouse = guesetHouseRepository.findById(scoreReq.getGuestHouseId()).get();
		List<Status> rStatusList = statusRepository.findByGuestHouse(guestHouse);
		int tmpScore = rStatusList.stream().filter((t) -> 
				t.getMember()
				.getMbti()
				.equals(rScore.getMbti()))
			.toList()
			.size();
		rScore.setTotalScore(rScore.getTotalScore()+tmpScore);
		
		return new ScoreRes(rScore);
	}
	
	@Transactional
	public ScoreRes initScore(ScoreReq scoreReq) throws Exception {
		Score rScore = scoreRepository.findByGuestHouseIdAndMbti(scoreReq.getGuestHouseId(), scoreReq.getMbti()).get();
		String mbti = guesetHouseRepository
				.findById(scoreReq.getGuestHouseId())
				.get()
				.getTags();
		rScore.setTotalScore((float)getScoreWithTags(parseTags(mbti), rScore.getMbti()));
		
		return new ScoreRes(rScore);
	}


}
