package com.demo.spring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.demo.spring.entity.Credentials;
import com.demo.spring.util.Message;

import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;

@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CredentialControllerTest {
	
	@LocalServerPort
	int port;
	
	@Autowired
	TestRestTemplate testRestTemplate;
	
	@Test
	void testFinduserSuccess() throws Exception{
		Credentials credentials =new Credentials("hello","hello");
		
//	HttpHeaders headers=new HttpHeaders();
//		headers.set("Content-type",MediaType.APPLICATION_JSON_VALUE);
//		HttpEntity<Credentials> req=new HttpEntity<>(credentials,headers);
//		ResponseEntity<Message> resp2=testrestTemplate.exchange("http://localhost:"+port+"/find",HttpMethod.POST,)
//		
		
		
	}

}
