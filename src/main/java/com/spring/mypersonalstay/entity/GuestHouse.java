package com.spring.mypersonalstay.entity;

import java.io.Serializable;
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
public class GuestHouse {

	@Id
	@Column(name = "guest_house_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long guestHouseId;
	
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
	@Column(name = "bg_img_url")
	private String bgImgUrl;
	
	@Lob
	@Column(name = "host_img_url")
	private String hostImgUrl;
	
	@CreationTimestamp
	private LocalDateTime regDate;

	@Override
	public String toString() {
		return "GuestHouse [guestHouseId=" + guestHouseId + ", name=" + name + ", location=" + location + ", capacity="
				+ capacity + ", description=" + description + ", tags=" + tags + ", bgImgUrl=" + bgImgUrl
				+ ", hostImgUrl=" + hostImgUrl + ", regDate=" + regDate + "]";
	}

	
	
}
