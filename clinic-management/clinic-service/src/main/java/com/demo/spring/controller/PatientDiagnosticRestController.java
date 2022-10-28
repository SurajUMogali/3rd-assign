package com.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.dto.PatientDTO;
import com.demo.spring.exceptions.DiagnosticNotFoundException;
import com.demo.spring.exceptions.PatientNotFoundException;
import com.demo.spring.services.PatientDiagnosticService;
import com.demo.spring.util.Message;
import com.demo.spring.util.ServerConfiguration;

import io.micrometer.core.annotation.Timed;

@EnableConfigurationProperties(ServerConfiguration.class)
@RestController
@RequestMapping("/clinic")
public class PatientDiagnosticRestController {
	@Autowired
	PatientDiagnosticService patientDiagnosticService;

	@Autowired
	ServerConfiguration server;

	@Autowired
	RestTemplate restTemplate;

	@Timed(value = "requests.patientdiag.save")
	@PostMapping(path = "/patientDiagnostic/save/{testId}/{patientId}")
	public ResponseEntity<Message> addTestToPatient(@PathVariable("testId") int testId,
			@PathVariable("patientId") int patientId)
			throws PatientNotFoundException, DiagnosticNotFoundException, NullPointerException {
		PatientDTO patientDTO = restTemplate
				.getForEntity(server.getPatientServer() + "/patient/{patientId}", PatientDTO.class, patientId)
				.getBody();
		if (patientDTO!=null && patientDTO.getPatientId() != null && patientDTO.getPatientId() == patientId) {
			return ResponseEntity.ok(patientDiagnosticService.addTestToPatient(patientId, testId));
		} else {
			throw new PatientNotFoundException();
		}
	}
}