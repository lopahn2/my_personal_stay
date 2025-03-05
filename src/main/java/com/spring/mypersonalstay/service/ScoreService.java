package com.spring.mypersonalstay.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.text.similarity.CosineSimilarity;
import org.apache.commons.text.similarity.JaroWinklerSimilarity;
import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.stereotype.Service;

import com.spring.mypersonalstay.dto.ScoreReq;
import com.spring.mypersonalstay.dto.ScoreRes;
import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.entity.Score;
import com.spring.mypersonalstay.entity.Status;
import com.spring.mypersonalstay.entity.Tag;
import com.spring.mypersonalstay.exception.CustomException;
import com.spring.mypersonalstay.exception.StatusCode;
import com.spring.mypersonalstay.repository.GuestHouseRepository;
import com.spring.mypersonalstay.repository.ScoreRepository;
import com.spring.mypersonalstay.repository.StatusRepository;
import com.spring.mypersonalstay.repository.TagRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ScoreService {
	private final ScoreRepository scoreRepository;
	private final GuestHouseRepository guestHouseRepository;
	private final StatusRepository statusRepository;
	private final TagRepository tagRepository;

	private static Random random = new Random();

	@Transactional
	public ScoreRes findScore(Long id) {
		Score rScore = scoreRepository.findById(id).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));

		return new ScoreRes(rScore);
	}

	@Transactional
	public ScoreRes initScore(ScoreReq scoreReq) {
		GuestHouse guestHouse = guestHouseRepository.findById(scoreReq.getGuestHouseId())
				.orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));

		Score rScore = guestHouse.getScores().stream().filter(s -> s.getMbti().equals(scoreReq.getMbti())).findFirst()
				.orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));

		String guestHouseTags = guestHouse.getTags();
		StringBuilder userMbtiTags = new StringBuilder();

		scoreReq.getMbti().chars().forEach(mbti -> {
			List<String> joinedTag = tagRepository.findBymFieldContains((char) mbti).stream().map(t -> t.getTagName())
					.collect(Collectors.toList());

			userMbtiTags.append(joinedTag.get(random.nextInt(joinedTag.size())));
			userMbtiTags.append(", ");
		});

		Map<CharSequence, Integer> firstVector = getTextVector(guestHouseTags);
		Map<CharSequence, Integer> secondVector = getTextVector(userMbtiTags.toString());

		CosineSimilarity cosine = new CosineSimilarity();
		Float cosineScore = cosine.cosineSimilarity(firstVector, secondVector).floatValue();

		rScore.setTotalScore(cosineScore * 100);
		return new ScoreRes(rScore);
	}

	@Transactional
	public ScoreRes updateScore(ScoreReq scoreReq) {
		GuestHouse guestHouse = guestHouseRepository.findById(scoreReq.getGuestHouseId())
				.orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		Score rScore = guestHouse.getScores().stream().filter(s -> s.getMbti().equals(scoreReq.getMbti())).findFirst()
				.orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));

		int count = statusRepository.findByGuestHouse(guestHouse).stream().filter(st -> st.getIsUsed())
				.filter(st -> st.getMember().getMbti().equals(scoreReq.getMbti())).collect(Collectors.toList()).size();
		

		float weight = count >= 10 ? Float.parseFloat("1." + count) : Float.parseFloat("1.0" + count);
		float tts = rScore.getTotalScore() * weight >= 100.0f ? 100.0f : rScore.getTotalScore() * weight;
		rScore.setTotalScore(tts);
		
		return new ScoreRes(rScore);
	}

	// 텍스트를 벡터로 변환하는 함수
	private static Map<CharSequence, Integer> getTextVector(CharSequence text) {
		Map<CharSequence, Integer> vector = new HashMap<>();
		String[] words = text.toString().split("[,\\s]+"); // 쉼표와 공백을 기준으로 단어 분할

		for (String word : words) {
			word = word.trim();
			if (!word.isEmpty()) {
				vector.put(word, vector.getOrDefault(word, 0) + 1); // 단어 빈도 계산
			}
		}
		return vector;
	}

}
