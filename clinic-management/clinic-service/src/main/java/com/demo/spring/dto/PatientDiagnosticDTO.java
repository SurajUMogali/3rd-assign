package com.demo.spring.dto;

public class PatientDiagnosticDTO {

	private Integer PatientID;

	private Integer DiagnosticID;

	public PatientDiagnosticDTO() {
	}

	public PatientDiagnosticDTO(Integer patientID, Integer diagnosticID) {
		super();
		PatientID = patientID;
		DiagnosticID = diagnosticID;
	}

	public Integer getPatientID() {
		return PatientID;
	}

	public void setPatientID(Integer patientID) {
		PatientID = patientID;
	}

	public Integer getDiagnosticID() {
		return DiagnosticID;
	}

	public void setDiagnosticID(Integer diagnosticID) {
		DiagnosticID = diagnosticID;
	}

}