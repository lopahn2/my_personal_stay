package com.spring.mypersonalstay.entity;

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
@Setter
@Getter
public class Tag {
	@Id
	@Column(name = "tag_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long tagId;
	
	
	@Column(name = "tag_name", length = 32)
	private String tagName;
	
	@Column(name = "m_field", length = 4)
	private String mField;

	@Override
	public String toString() {
		return "Tag [tagId=" + tagId + ", tagName=" + tagName + ", mField=" + mField + "]";
	}
}
