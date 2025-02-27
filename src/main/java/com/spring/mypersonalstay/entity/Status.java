package com.spring.mypersonalstay.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Status {
	@Id
	@Column(name = "status_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long statusId;

	private Boolean isLiked;
	
	private Boolean isBooked;
	
	private Boolean isUsed;

	@CreationTimestamp
	private LocalDateTime regDate;
	
	private Member member;
	private GuestHoust guestHouse;
}
