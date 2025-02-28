package com.spring.mypersonalstay.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "guest_house_score", joinColumns = @JoinColumn(name = "guest_house_id"), inverseJoinColumns = @JoinColumn(name = "score_id"))
	private List<Score> scores;

	@Override
	public String toString() {
		return "GuestHouse [guestHouseId=" + guestHouseId + ", name=" + name + ", location=" + location + ", capacity="
				+ capacity + ", description=" + description + ", tags=" + tags + ", bgImgUrl=" + bgImgUrl
				+ ", hostImgUrl=" + hostImgUrl + ", regDate=" + regDate + "]";
	}

	
	
}
