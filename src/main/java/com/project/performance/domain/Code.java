package com.project.performance.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "code")
public class Code {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "unique_code", unique = true)
	private UUID uniqueCode;

	public Code(UUID uniqueCode) {
		this.uniqueCode = uniqueCode;
	}
	
	public Code() {
		
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UUID getUniqueCode() {
		return uniqueCode;
	}

	public void setUniqueCode(UUID uniqueCode) {
		this.uniqueCode = uniqueCode;
	}

}
