package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "APPOINTMENT")
public class Appointment {
	@Id
	@Column(name = "APPOINTMENT_ID")
	private Integer appointmentId;

	@Column(name = "DOCTOR_ID")
	private Integer doctorId;

	@Column(name = "PATIENT_ID")
	private Integer patientId;

	@Column(name = "DATE")
	private String date;

	public Appointment() {
		super();
	}

	public Appointment(Integer appointmentId, Integer doctorId, Integer patientId, String date) {
		super();
		this.appointmentId = appointmentId;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.date = date;
	}

	public Integer getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(Integer appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	
	
}
