package com.spring.jpql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Role {
	@Id
	@Column(name="role_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer roleId;
	
	@Column(length = 20)
	private String name;

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", name=" + name + "]";
	}
	
	
}
