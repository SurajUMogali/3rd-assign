package com.demo.spring.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DoctorSpecialityTest {
	
	@Test
	void testDoctorSpeciality() {
		DoctorSpeciality doctorSpeciality = new DoctorSpeciality();
		doctorSpeciality.setDoctorId(101);
		doctorSpeciality.setSpecialityId(2);

		assertEquals(101, doctorSpeciality.getDoctorId());
		assertEquals(2, doctorSpeciality.getSpecialityId());

	}
	
	

	
	
}
