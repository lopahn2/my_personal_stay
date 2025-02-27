package com.spring.mypersonalstay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.mypersonalstay.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}
