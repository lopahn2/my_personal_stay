package com.spring.jpql.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@ToString
public class Board {

	@Id
	@Column(name = "board_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long boardId;

	@Column(length = 100)
	private String title;

	@Lob // varchar 보다 더 큰 용량
	private String content;

	private int count;

	@CreationTimestamp
	private LocalDateTime regDate;

	// OneToMany VS ManyToOne 한 명의 고객이 여러개의 게시글을 작성 => 작성하는 클래스의 역할 기준으로 . 여기서는
	// ManyToOne
	// 엔티티 관계를 지정할 때에는 Fetch Type이 중요하다.
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "custom_id")
	private Custom custom;
 
	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", title=" + title + ", content=" + content + ", count=" + count
				+ ", regDate=" + regDate + "]";
	}

}
