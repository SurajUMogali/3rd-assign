package com.demo.spring;
//package com.demo.spring.controller;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//
//import com.demo.spring.repository.DiagnosticRepository;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@AutoConfigureMockMvc
//public class PatientDiagnosticControllerTest {
//	
//	@Autowired
//	MockMvc mvc;
//	
//	@MockBean
//	PatientDiagnosticRepository patientDiagnosticrepository;
//	
//	@Test
//	void testAddTest()  throws Exception{
//		ObjectMapper mapper = new ObjectMapper();
//		String diagnosticJson = mapper.writeValueAsString(diagnostic);
//		when(patientDiagnosticrepository.existsById(1)).thenReturn(false);
//		
//		mvc.perform(post("/diagnostic/addTest").content(diagnosticJson).contentType(MediaType.APPLICATION_JSON_VALUE))
//			.andDo(print())
//			.andExpect(status().isOk())
//			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
//			.andExpect(jsonPath("$.status").value("Test added"));
//	}
//
//}
