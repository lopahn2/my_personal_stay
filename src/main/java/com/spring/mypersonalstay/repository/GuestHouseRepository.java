package com.spring.mypersonalstay.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.mypersonalstay.entity.GuestHouse;

@Repository
public interface GuestHouseRepository extends JpaRepository<GuestHouse, Long> {
	List<GuestHouse> findByName(String name);

	List<GuestHouse> findByTagsContains(String tag);

	List<GuestHouse> findByCapacityBetween(Integer min, Integer max);
	
	Optional<GuestHouse> findById(Long guestHouseid);

	// 모든 게스트 하우스 점수 보여주기
	@Query(value = "SELECT gh FROM GuestHouse gh JOIN FETCH gh.scores")
	List<GuestHouse> getAllGuestHousesScore();

	// 특정 게스트 하우스 점수 보여주기
	@Query(value = "SELECT gh FROM GuestHouse gh JOIN FETCH gh.scores WHERE gh.guestHouseId = :guestHouseId")
	Optional<GuestHouse> getGuestHouseScore(@Param("guestHouseId") Long guestHouseId);
}
