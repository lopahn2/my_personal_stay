package com.spring.mypersonalstay.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.mypersonalstay.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{

}
