package com.demo.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.spring.dto.AppointmentDTO;
import com.demo.spring.entity.Appointment;
import com.demo.spring.entity.Message;
import com.demo.spring.exception.AppointmentNotFoundException;
import com.demo.spring.repository.AppointmentRepository;

@Service
public class AppointmentService {

	@Autowired
	AppointmentRepository appointmentRepository;

	public ResponseEntity<List<Appointment>> findAllAppointmentsService() {
		return ResponseEntity.ok(appointmentRepository.findAll());
	}

	public ResponseEntity<List<Appointment>> findAppointmentsByDateService(int doctorID, String date)
			throws AppointmentNotFoundException {
		List<Appointment> listAppointment = appointmentRepository.findAllByDate(doctorID, date);
		if (listAppointment.isEmpty()) {
			throw new AppointmentNotFoundException();
		} else {
			return ResponseEntity.ok(listAppointment);
		}
	}

	public ResponseEntity<Message> getAppointmentService(AppointmentDTO appointmentDTO) {
		if (appointmentRepository.existsById(appointmentDTO.getAppointmentId())) {
			return ResponseEntity.ok(new Message("Appointment already exists"));
		} else {
			Appointment appointment = new Appointment(appointmentDTO.getAppointmentId(), appointmentDTO.getDoctorId(),
					appointmentDTO.getPatientId(), appointmentDTO.getDate());
			appointmentRepository.save(appointment);
			return ResponseEntity.ok(new Message("Appointment saved"));
		}

	}
	
	
	
	

}
