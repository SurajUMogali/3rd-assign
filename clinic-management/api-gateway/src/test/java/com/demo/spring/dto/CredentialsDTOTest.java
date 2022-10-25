package com.demo.spring.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CredentialsDTOTest {
	
	@Test
	void testCredentialsDTO() {
		CredentialsDTO credentialsDTO=new CredentialsDTO();
		credentialsDTO.setUserName("receptionist");
		credentialsDTO.setPassword("receptionist");
		
		assertEquals("receptionist",credentialsDTO.getUserName());
		assertEquals("receptionist",credentialsDTO.getPassword());
		
		
		
		
	}

}
