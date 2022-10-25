package com.demo.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.spring.dto.PatientDTO;
import com.demo.spring.entity.Message;
import com.demo.spring.entity.Patient;
import com.demo.spring.exceptions.PatientNotExistsException;
import com.demo.spring.exceptions.PatientNotFoundException;
import com.demo.spring.repository.PatientRepository;

@Service
public class PatientService {

	@Autowired
	PatientRepository patientRepository;

	public ResponseEntity<Patient> findOneEmpService(int patientId) throws PatientNotExistsException {
		Optional<Patient> patOp = patientRepository.findById(patientId);
		if (patOp.isPresent()) {
			return ResponseEntity.ok(patOp.get());
		} else {
			throw new PatientNotExistsException();
			

		}

	}

	public ResponseEntity<Message> savePatientService(PatientDTO patientDTO) {
		if (patientRepository.existsById(patientDTO.getPatientId())) {
			return ResponseEntity.ok(new Message("Patient already exists"));
		} else {
			Patient patient = new Patient(patientDTO.getPatientId(), patientDTO.getFirstName(),
					patientDTO.getLastName(), patientDTO.getEmail());
			patientRepository.save(patient);
			return ResponseEntity.ok(new Message("Patient saved"));
		}

	}

	public ResponseEntity<List<Patient>> listByPatientNameService(String fname) throws PatientNotFoundException {
		List<Patient> patientList = patientRepository.findAllByFirstName(fname);
		if (patientList.isEmpty()) {
			throw new PatientNotFoundException();
		} else {
			return ResponseEntity.ok(patientList);
		}

	}

}
