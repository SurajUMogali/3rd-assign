package com.demo.spring.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DoctorTest {

	@Test
	void testDoctor() {
		Doctor doctor = new Doctor();
		doctor.setFirstName("suraj");
		doctor.setLastName("mogali");
		doctor.setEmail("surajmogali@gmail.com");
		doctor.setDoctorId(101);

		assertEquals("suraj", doctor.getFirstName());
		assertEquals("mogali", doctor.getLastName());
		assertEquals("surajmogali@gmail.com", doctor.getEmail());
		assertEquals(101, doctor.getDoctorId());

	}
}
