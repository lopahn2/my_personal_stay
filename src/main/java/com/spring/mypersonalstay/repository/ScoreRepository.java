package com.spring.mypersonalstay.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.mypersonalstay.entity.Score;

@Repository
public interface ScoreRepository extends JpaRepository<Score, Long>{
<<<<<<< Updated upstream
=======
	
//	Optional<Score> findByGuestHouseIdAndMbti(Long guestHouseId, String mbti);
	
>>>>>>> Stashed changes

}
