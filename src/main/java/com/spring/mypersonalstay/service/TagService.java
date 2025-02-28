package com.spring.mypersonalstay.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.mypersonalstay.entity.Tag;
import com.spring.mypersonalstay.repository.TagRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TagService {
//	private final TagRepository tagRepository;
//	
//	@Transactional
//	private List<Tag> getAllTags() {
//		List<Tag> res = tagRepository.findAll();
//		return res;
//	}	
//	
//	@Transactional
//	private Optional<Tag> getTagById(Integer id) {
//		Optional<Tag> res = tagRepository.findById(id);
//		if (res.isPresent()) return res;
//		return null;
//	}	
//	
//	@Transactional
//	private List<Tag> getTagByName(String name) {
//		List<Tag> res = tagRepository.findByNameContains(name);
//		return res;
//	}	
//	
//	@Transactional
//	private List<Tag> getTagByMField(String mField) {
//		List<Tag> res = tagRepository.findByNameContains(mField);
//		return res;
//	}
//	
//	@Transactional
//	private void addTag(String name, String mField) {
//		
//	}	
//	
//	@Transactional
//	private void deleteTag(Integer id) {
//		
//	}	
//	
//	@Transactional
//	private void updateTag(Integer id, String name, String mField) {
//		
//	}
	
}
