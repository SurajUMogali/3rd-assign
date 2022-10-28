package com.demo.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.dto.DoctorSpecialityDTO;
import com.demo.spring.entity.Doctor;
import com.demo.spring.exceptions.DoctorNotFoundException;
import com.demo.spring.exceptions.DoctorSpecialityNotFoundException;
import com.demo.spring.services.DoctorSpecialityService;
import com.demo.spring.util.Message;

import io.micrometer.core.annotation.Timed;

@RestController
@RequestMapping("/clinic")
public class DoctorSpecialityRestController {

	@Autowired
	DoctorSpecialityService specialityService;

	@Timed(value = "requests.speciality.findbyid")
	@GetMapping(path = "/speciality/list/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Doctor>> listAllDoctor(@PathVariable("id") Integer id) throws DoctorSpecialityNotFoundException, DoctorNotFoundException {
		List<Doctor> doctorList =specialityService.listDoctorInSpeciality(id);
		if(doctorList.isEmpty()) {
			throw new DoctorSpecialityNotFoundException();
		}else {
			return ResponseEntity.ok(doctorList);
		}
		
	}
	
	@Timed(value = "requests.speciality.addDoctor")
	@PostMapping(path="/speciality/addDoctor" ,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> addDoctorToSpeciality(@RequestBody DoctorSpecialityDTO doctorSpecialityDTO) throws DoctorNotFoundException{
 
        return ResponseEntity.ok(specialityService.addDoctorService(doctorSpecialityDTO));
    }
	
	@Timed(value = "requests.speciality.remove")
	@DeleteMapping(path = "/speciality/removeDoctor/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Message> removeDoctor(@PathVariable("id") Integer id) throws DoctorNotFoundException {
		return ResponseEntity.ok(specialityService.removeDoctor(id));
	}

}
