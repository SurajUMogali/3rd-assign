package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dto.DiagnosticDTO;
import com.demo.spring.entity.Diagnostic;
import com.demo.spring.exceptions.DiagnosticNotFoundException;
import com.demo.spring.exceptions.DiagnosticTestExistsException;
import com.demo.spring.services.DiagnosticService;
import com.demo.spring.util.Message;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/clinic")
public class DiagnosticRestController {

	@Autowired
	DiagnosticService diagnosticService;
	
	
	@Timed(value = "requests.diagnostic.list")
	@GetMapping(path="/diagnostic/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Diagnostic>> listAllDiagnostics() {
			return ResponseEntity.ok(diagnosticService.listAll());
	}
	
	@Timed(value = "requests.diagnostic.addtest")
	@PostMapping(path="/diagnostic/addTest" ,consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> addTest(@RequestBody DiagnosticDTO diagnosticDto) throws DiagnosticTestExistsException{
		return ResponseEntity.ok(diagnosticService.addTests(diagnosticDto));
	}
	
	@Timed(value = "requests.diagnostic.delete")
	@DeleteMapping(path="/diagnostic/removeTest/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> removeTest(@PathVariable("id") Integer id) throws DiagnosticNotFoundException{
		return ResponseEntity.ok(diagnosticService.removeTests(id));
	}
}
