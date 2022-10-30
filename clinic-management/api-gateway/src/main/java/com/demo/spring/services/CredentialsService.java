package com.demo.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Credentials;
import com.demo.spring.exceptions.UserNameExistsException;
import com.demo.spring.exceptions.UserNotFoundException;
import com.demo.spring.repository.CredentialRepository;
import com.demo.spring.util.Message;

@Service
public class CredentialsService {

	@Autowired
	CredentialRepository credentialRepository;

	public Message findUserNameService(Credentials credentials) throws UserNotFoundException {
		List<Credentials> listCred = credentialRepository.findUser(credentials.getUserName(),
				credentials.getPassword());
		if (listCred.isEmpty()) {
			throw new UserNotFoundException();
		} else {
			return new Message("User Found");
		}
	}

	public Message updateUser(Credentials credentials) throws UserNotFoundException {
		Optional<Credentials> credOp = credentialRepository.findById(credentials.getUserName());
		if (credOp.isEmpty()) {
			throw new UserNotFoundException();
		} else {
			credentialRepository.updateUser(credentials.getUserName(), credentials.getPassword());
			return new Message("User Updated");
		}
	}

	
}