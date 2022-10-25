package com.demo.spring.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.dto.DoctorSpecialityDTO;
import com.demo.spring.entity.Doctor;
import com.demo.spring.entity.DoctorSpeciality;
import com.demo.spring.exceptions.DoctorNotFoundException;
import com.demo.spring.exceptions.DoctorSpecialityNotFoundException;
import com.demo.spring.repository.DoctorRepository;
import com.demo.spring.repository.DoctorSpecialityRepository;
import com.demo.spring.util.Message;

@Service
public class DoctorSpecialityService {

	@Autowired
	DoctorSpecialityRepository doctorspecialityRepository;

	@Autowired
	DoctorRepository doctorRepository;

	public Message addDoctorService(DoctorSpecialityDTO doctorSpecialityDTO) throws DoctorNotFoundException {

		if (doctorRepository.existsById(doctorSpecialityDTO.getDoctorId())) {
			DoctorSpeciality doctorSpeciality = new DoctorSpeciality(doctorSpecialityDTO.getId(),
					doctorSpecialityDTO.getDoctorId(), doctorSpecialityDTO.getSpecialityId());
			doctorspecialityRepository.save(doctorSpeciality);
			return new Message("Doctor added to speciality");
		} else {
			throw new DoctorNotFoundException();
		}

	}

	public Message removeDoctor(Integer doctorId) throws DoctorNotFoundException {
		Optional<DoctorSpeciality> doctorOps = doctorspecialityRepository.findById(doctorId);
		if (doctorOps.isPresent()) {
			doctorspecialityRepository.delete(doctorOps.get());
			return new Message("Doctor remove from speciality");
		} else {
			throw new DoctorNotFoundException();
		}

	}

	public List<Doctor> listDoctorInSpeciality(Integer specialityID)
			throws DoctorSpecialityNotFoundException, DoctorNotFoundException {
		List<DoctorSpeciality> doctorIdList = doctorspecialityRepository.findAllDoctor(specialityID);
		Integer i = 0;
		List<Doctor> doctorList = new ArrayList<>();
		if (doctorIdList.isEmpty()) {
			throw new DoctorNotFoundException();
		} else {
			for (doctorRepository.existsById(doctorIdList.get(i).getDoctorId()); i < doctorIdList.size(); i++) {

				Optional<Doctor> doctorOps = doctorRepository.findById(doctorIdList.get(i).getDoctorId());
				if (doctorOps.isPresent()) {
					doctorList.add(doctorOps.get());
				}
			}
			if (doctorList.isEmpty()) {
				throw new DoctorSpecialityNotFoundException();
			} else {
				return doctorList;
			}
		}
	}

}
