package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SPECIALITY")
public class Speciality {

	@Id
	@Column(name="SPECIALITY_ID")
	private Integer specialityId;
	@Column(name="SPECIALITY_NAME")
	private String specialityName;

	public Speciality() {
		
	}

	public Speciality(Integer specialityId, String specialityName) {
	
		this.specialityId = specialityId;
		this.specialityName = specialityName;
	}

	public Integer getSpecialityId() {
		return specialityId;
	}

	public void setSpecialityId(Integer specialityId) {
		this.specialityId = specialityId;
	}

	public String getSpecialityName() {
		return specialityName;
	}

	public void setSpecialityName(String specialityName) {
		this.specialityName = specialityName;
	}

}
