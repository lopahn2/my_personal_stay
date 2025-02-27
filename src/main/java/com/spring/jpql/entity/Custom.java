package com.spring.jpql.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
//@ToString
public class Custom {

	@Id
	@Column(name = "custom_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customId;

	@Column(length = 20)
	private String password;

	@Column(length = 30)
	private String name;

	@Column(length = 300)
	private String email;

	@CreationTimestamp
	private LocalDateTime regDate;

	// join column
	// entity가 associate되었을 때에는 ToString을 사용하면 안된다. => 성능 저하
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "custome_role", joinColumns = @JoinColumn(name = "custom_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	Set<Role> roles = new HashSet<>();

	@Override
	public String toString() {
		return "Custom [customId=" + customId + ", password=" + password + ", name=" + name + ", email=" + email
				+ ", regDate=" + regDate + "]";
	}

}
