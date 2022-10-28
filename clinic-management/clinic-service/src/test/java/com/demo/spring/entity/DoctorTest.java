package com.demo.spring.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.demo.spring.dto.DoctorDTO;

public class DoctorTest {

	@Test
	void testDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("suraj");
		doctor.setLastName("mogali");
		doctor.setEmail("surajmogali@gmail.com");
		doctor.setDoctorId(101);
		
		DoctorDTO doctorDTO2 = new DoctorDTO(101,"suraj","mogali","surajmogali@gmail.com");

		assertEquals("suraj", doctor.getFirstName());
		assertEquals("mogali", doctor.getLastName());
		assertEquals("surajmogali@gmail.com", doctor.getEmail());
		assertEquals(101, doctor.getDoctorId());

	}
}
