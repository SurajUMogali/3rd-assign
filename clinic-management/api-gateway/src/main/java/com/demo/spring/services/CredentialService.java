package com.demo.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Credentials;
import com.demo.spring.exceptions.UserNotExistsException;
import com.demo.spring.exceptions.UserNotFoundException;
import com.demo.spring.repository.CredentialRepository;
import com.demo.spring.util.Message;

@Service
public class CredentialService {

	@Autowired
	CredentialRepository credentialRepository;

	public Message findUser(Credentials credentials) throws UserNotExistsException, UserNotFoundException {
		List<Credentials> listCred = credentialRepository.findUser(credentials.getUserName(),
				credentials.getPassword());
		if (listCred.isEmpty()) {
			throw new UserNotFoundException();
		} else {
			return new Message("User Found");
		}
	}

	public Message updateUser(Credentials credentials) throws UserNotExistsException {
		Optional<Credentials> credOp = credentialRepository.findById(credentials.getUserName());
		if (credOp.isEmpty()) {
			throw new UserNotExistsException();
		} else {
			credentialRepository.updateUser(credentials.getUserName(), credentials.getPassword());
			return new Message("User Updated");
		}
	}
}