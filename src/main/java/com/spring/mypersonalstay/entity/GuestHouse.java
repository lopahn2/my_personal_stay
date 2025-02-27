package com.spring.mypersonalstay.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class GuestHouse {

	@Id
	@Column(name = "guesthouse_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guest_house_id;
	
	@Column(length=100)
	private String name;
	
	@Column(length=100)
	private String location;
	
	private int capacity;
	
	@Lob
	private String description;
	
	@Lob
	private String tags;
	
	@Lob
	private String bg_img_url;
	
	@Lob
	private String host_img_url;
	
	@CreationTimestamp
	private LocalDateTime regDate;

	@Override
	public String toString() {
		return "GuestHouse [guest_house_id=" + guest_house_id + ", name=" + name + ", location=" + location
				+ ", capacity=" + capacity + ", description=" + description + ", regDate=" + regDate + "]";
	}
	
}
