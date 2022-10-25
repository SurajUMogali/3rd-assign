package com.demo.spring.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class DiagnosticTest {
	@Test
	void testDiagnostic() {
		Diagnostic diagnostic = new Diagnostic();
		diagnostic.setDiagnosticId(1);
		diagnostic.setDiagnosticName("Biopsy");

		assertEquals(1, diagnostic.getDiagnosticId());
		assertEquals("Biopsy", diagnostic.getDiagnosticName());

	}

}
