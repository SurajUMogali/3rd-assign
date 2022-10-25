package com.demo.spring.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PatientDiagnosticDTOTest {

	@Test
	void testPtientDiagnostic() {
		PatientDiagnostic patientDiagnostic = new PatientDiagnostic();
		patientDiagnostic.setDiagnosticID(3);
		patientDiagnostic.setPatientID(201);

		assertEquals(3, patientDiagnostic.getDiagnosticID());
		assertEquals(201, patientDiagnostic.getPatientID());

	}

}
