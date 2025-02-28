package com.spring.mypersonalstay.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.mypersonalstay.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{
//	List<Tag> findAll();
//
//	Optional<Tag> findById(Integer id);
//
//	List<Tag> findByNameContains(String name);
}
