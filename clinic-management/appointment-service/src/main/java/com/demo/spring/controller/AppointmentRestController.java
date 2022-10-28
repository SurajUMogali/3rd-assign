package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.spring.dto.AppointmentDTO;
import com.demo.spring.dto.DoctorDTO;
import com.demo.spring.dto.PatientDTO;
import com.demo.spring.entity.Appointment;
import com.demo.spring.entity.Message;
import com.demo.spring.exception.AppointmentNotFoundException;
import com.demo.spring.exceptions.DoctorNotFoundException;
import com.demo.spring.exceptions.PatientNotExistsException;
import com.demo.spring.services.AppointmentService;
import com.demo.spring.util.ServerConfiguration;

import io.micrometer.core.annotation.Timed;
import io.swagger.v3.oas.annotations.OpenAPI30;

@RestController
@EnableConfigurationProperties(ServerConfiguration.class)
@RequestMapping("/appointment")
@OpenAPI30
public class AppointmentRestController {

	@Autowired
	AppointmentService appointmentService;
	
	

	@Timed(value = "requests.count.list")
	@GetMapping(path = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Appointment>> findAllAppointments() {
		return (appointmentService.findAllAppointmentsService());
	}

	@Timed(value = "requests.count.listbydate")
	@GetMapping(path = "/listbyDate/{doctorID}/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Appointment>> findAppointmentsByDate(@PathVariable("doctorID") int doctorID,
			@PathVariable("date") String date) throws AppointmentNotFoundException {
		return appointmentService.findAppointmentsByDateService(doctorID, date);
	}

//    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Message> savePatient(@RequestBody AppointmentDTO appointDTO) {
//		if (appointmentRepo.existsById(appointDTO.getPatientId())) {
//			return ResponseEntity.ok(new Message("Appointment already exists"));
//		} else {
//			Appointment appointment=new Appointment(appointDTO.getAppointmentId(),appointDTO.getPatientId(),appointDTO.getDoctorId(),
//					appointDTO.getDate());
//			appointmentRepo.save(appoint);
//			return ResponseEntity.ok(new Message("Appointment taken"));
//		}
//
//	}

//	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Message> getAppointment(@RequestBody AppointmentDTO appointmentDTO) {
//		return appointmentService.getAppointmentService(appointmentDTO);
//
//	}

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	ServerConfiguration server;

	@PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
	@Timed(value = "request.add.appointment")
	public ResponseEntity<Message> addAppointment(@RequestBody AppointmentDTO appointmentDTO)
			throws PatientNotExistsException, DoctorNotFoundException, NullPointerException {
		PatientDTO patientDTO = restTemplate.getForEntity(server.getPatientServer() + "/patient/{id}", PatientDTO.class,
				appointmentDTO.getPatientId()).getBody();

		if (patientDTO != null && patientDTO.getPatientId() != null
				&& patientDTO.getPatientId().equals(appointmentDTO.getPatientId())) {
			DoctorDTO doctorDTO = restTemplate.getForEntity(server.getClinicServer() + "/clinic/doctor/find/{doctorId}",
					DoctorDTO.class, appointmentDTO.getDoctorId()).getBody();

			if (doctorDTO != null && doctorDTO.getDoctorId() != null
					&& doctorDTO.getDoctorId().equals(appointmentDTO.getDoctorId())) {
				return appointmentService.getAppointmentService(appointmentDTO);
			} else {
				throw new DoctorNotFoundException();
			}

		} else {
			throw new PatientNotExistsException();
		}

	}

}
