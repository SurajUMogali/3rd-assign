package com.demo.spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Doctor;
import com.demo.spring.exceptions.DoctorNotFoundException;
import com.demo.spring.repository.DoctorRepository;

@Service
public class DoctorService {

	
	@Autowired
	DoctorRepository doctorRepository;
	
	public List<Doctor> listAllData(){
		return doctorRepository.findAll();
	}
	
	public ResponseEntity<Doctor> findOneDocService(int doctorId) throws DoctorNotFoundException {
		Optional<Doctor> docOp = doctorRepository.findById(doctorId);
		if (docOp.isPresent()) {
			return ResponseEntity.ok(docOp.get());
		} else {
			throw new DoctorNotFoundException();

		}

	}

}
