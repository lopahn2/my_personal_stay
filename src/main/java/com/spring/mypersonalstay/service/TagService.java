package com.spring.mypersonalstay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.mypersonalstay.dto.tag.TagIdSearchRequestDTO;
import com.spring.mypersonalstay.dto.tag.TagMFieldSearchRequestDTO;
import com.spring.mypersonalstay.dto.tag.TagNameSearchRequestDTO;
import com.spring.mypersonalstay.entity.Tag;
import com.spring.mypersonalstay.exception.CustomException;
import com.spring.mypersonalstay.exception.StatusCode;
import com.spring.mypersonalstay.repository.TagRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {

	private final TagRepository tagRepository;
	
	@Transactional
	private List<Tag> getAllTags() {
		List<Tag> res = tagRepository.findAll();
		return res;
	}	
	
	@Transactional
	private Tag getTagById(TagIdSearchRequestDTO req) {
		Tag res = tagRepository.findByTagId(req.getId()).orElseThrow(() -> new CustomException(StatusCode.NOT_FOUND));
		return res;
	}	
	
	@Transactional
	private List<Tag> getTagByName(TagNameSearchRequestDTO req) {
		List<Tag> res = tagRepository.findByTagNameContains(req.getTagName());
		return res;
	}	
	
	@Transactional
	private List<Tag> getTagByMField(TagMFieldSearchRequestDTO req) {
		List<Tag> res = tagRepository.findBymFieldContains(req.getMField());
		return res;
	}


	
}
