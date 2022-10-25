package com.demo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.spring.entity.DoctorSpeciality;

public interface DoctorSpecialityRepository extends JpaRepository<DoctorSpeciality, Integer> {

	@Query("select d from DoctorSpeciality d where d.specialityId=:specialityId")
	public List<DoctorSpeciality> findAllDoctor(Integer specialityId);

}
