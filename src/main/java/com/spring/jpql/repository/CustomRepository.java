package com.spring.jpql.repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.jpql.entity.Custom;

import java.time.LocalDateTime;


@Repository
public interface CustomRepository extends JpaRepository<Custom, Integer>{
	/*
	 * save() --> persist()
	 * findById() --> find()
	 * findAll() --> find()
	 * deleteById() --> remove()
	 * delete() --> remove()
	*/
	
	Optional<List<Custom>> findByName(String name);
	
	Custom findByNameAndEmail(String name, String email);
	
	List<Custom> findByCustomIdBetween(Integer id1, Integer id2);
	
	List<Custom> findByCustomIdLessThan(Integer id);
	
	// 고객 등록일자가 어제 이후에 등록된 고객만 검색
	List<Custom> findByRegDateAfter(LocalDateTime regDate);
	
	// 고객 등록일자가 어제 이전에 등록된 고객만 검색
	List<Custom> findByRegDateBefore(LocalDateTime regDate);
	
	// 고객 이름이 김씨로 시작
	List<Custom> findByNameStartingWith(String nameKey);
	List<Custom> findByNameLike(String nameKey);
	
	// 정렬 ( 고객 아이디로 내림차순 )
	// A로 시작하는 고객 이름을 검색... customId로 내림차순 정렬
	List<Custom> findByNameStartingWithOrderByCustomIdDesc(String nameKey);
	
	// 고객 아이디가 2, 4, 6번인 고객들을 검색... Select * From Custom where custom_id in [2, 4, 6]
//	List<Custom> findByCustomIdIn(int[] ids);
	List<Custom> findByCustomIdIn(Collection<Integer> ids);
	
	
}
