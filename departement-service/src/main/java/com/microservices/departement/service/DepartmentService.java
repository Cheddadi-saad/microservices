package com.microservices.departement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.departement.entity.Department;
import com.microservices.departement.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("Insid of saveDepartment of DepartmentService");
		return departmentRepository.save(department);
	}

	public Optional<Department> findDepartmentById(Long departmentId) {
		log.info("Insid of findDepartmentById of DepartmentService");
		return departmentRepository.findById(departmentId);
	}

	public void deleteDepartmenetById(Long departmentId) {
		log.info("Insid of deleteDepartmenetById of DepartmentService");
		departmentRepository.deleteById(departmentId);
		
	}
}
