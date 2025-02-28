package com.spring.mypersonalstay.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mypersonalstay.entity.GuestHouse;
import com.spring.mypersonalstay.entity.Member;
import com.spring.mypersonalstay.entity.Status;

public interface StatusRepository extends JpaRepository<Status, Long> {
	List<Status> findByMember(Member member);
	List<Status> findByGuestHouse(GuestHouse guestHouse);
	List<Status> findByMemberAndGuestHouse(Member member, GuestHouse guestHouse);
	List<Status> findByMemberAndIsLiked(Member member, Boolean isLiked);
	List<Status> findByMemberAndIsBooked(Member member, Boolean isBooked);
	
	
}
