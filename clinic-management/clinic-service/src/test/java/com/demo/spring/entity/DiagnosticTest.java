package com.demo.spring.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.demo.spring.dto.DiagnosticDTO;

public class DiagnosticTest {
	@Test
	void testDiagnostic() {
		Diagnostic diagnostic = new Diagnostic();
		diagnostic.setDiagnosticId(1);
		diagnostic.setDiagnosticName("Biopsy");
		
		DiagnosticDTO diagnosticDTO2 = new DiagnosticDTO(1,"Biopsy");

		assertEquals(1, diagnostic.getDiagnosticId());
		assertEquals("Biopsy", diagnostic.getDiagnosticName());

	}

}
