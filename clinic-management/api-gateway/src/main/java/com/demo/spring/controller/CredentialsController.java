package com.demo.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dto.CredentialsDTO;
import com.demo.spring.entity.Credentials;
import com.demo.spring.exceptions.UserNotExistsException;
import com.demo.spring.exceptions.UserNotFoundException;
import com.demo.spring.services.CredentialService;
import com.demo.spring.util.Message;

@RestController
public class CredentialsController {

	@Autowired
	CredentialService credentialService;

	@PostMapping(path = "/find", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> finduser(@RequestBody CredentialsDTO credentialsDTO)
			throws UserNotExistsException, UserNotFoundException {
		Credentials credentials = new Credentials(credentialsDTO.getUserName(), credentialsDTO.getPassword());
		return ResponseEntity.ok(credentialService.findUser(credentials));
	}

	@PatchMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> updatePassword(@RequestBody CredentialsDTO credentialsDTO)
			throws UserNotExistsException {
		Credentials credentials = new Credentials(credentialsDTO.getUserName(), credentialsDTO.getPassword());
		return ResponseEntity.ok(credentialService.updateUser(credentials));
	}

}
