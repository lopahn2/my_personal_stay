package com.spring.mypersonalstay.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.mypersonalstay.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{

	List<Tag> findAll();

	List<Tag> findByTagNameContains(String name);
	
	List<Tag> findBymFieldContains(Character mField);
	
	Optional<Tag> findByTagName(String tagName);

	Optional<Tag> findByTagId(Integer id);
}
