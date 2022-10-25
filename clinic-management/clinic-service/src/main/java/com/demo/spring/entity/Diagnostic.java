package com.demo.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIAGNOSTIC")
public class Diagnostic {

	@Id
	@Column(name = "DIAGNOSTIC_ID")
	private Integer diagnosticId;
	@Column(name = "DIAGNOSTIC_NAME")
	private String diagnosticName;

	public Diagnostic() {
		super();
	}

	public Diagnostic(Integer diagnosticId, String diagnosticName) {
		super();
		this.diagnosticId = diagnosticId;
		this.diagnosticName = diagnosticName;
	}

	public Integer getDiagnosticId() {
		return diagnosticId;
	}

	public void setDiagnosticId(Integer diagnosticId) {
		this.diagnosticId = diagnosticId;
	}

	public String getDiagnosticName() {
		return diagnosticName;
	}

	public void setDiagnosticName(String diagnosticName) {
		this.diagnosticName = diagnosticName;
	}

}
