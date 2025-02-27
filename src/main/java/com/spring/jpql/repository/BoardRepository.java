package com.spring.jpql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.jpql.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

	// @Query(value = "SELECT b FROM Board b")
	// @Query(value = "SELECT b FROM Board b JOIN b.custom") // join 사용
	@Query(value = "SELECT b FROM Board b JOIN FETCH b.custom") // Fetch Join 사용
//	@Query(value = "SELECT b FROM Board b JOIN FETCH Custom c ON b.custom.customId = c.customId") // 일반적인 join => N+1 문제 해결이 안되더라.
	List<Board> getBoards(); 
	
	@Query(value = "SELECT COUNT(boardId) FROM Board b") // 디비 컬럼명이 아닌 @Id로 지정된 필드명
	Long getBoardCount();
	
	// 관리자 권한 가진 사람이 쓴 정보를 검색
	@Query(value = "SELECT b FROM Board b JOIN FETCH b.custom c JOIN FETCH c.roles r WHERE r.name=:roleName")
	List<Board> getBoards(@Param("roleName") String roleName);
}
