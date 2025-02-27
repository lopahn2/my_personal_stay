package com.spring.mypersonalstay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mypersonalstay.entity.GuestHouse;

public interface GuestHouseRepository extends JpaRepository<GuestHouse, Long> {
	List<GuestHouse> findAll();
	List<GuestHouse> findByName(String name);
	List<GuestHouse> findByTagsContains(String tag);
	List<GuestHouse> findByCapacityBetween(Integer min, Integer max);
}
