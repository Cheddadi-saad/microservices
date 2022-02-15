package com.microservices.departement.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.departement.entity.Department;
import com.microservices.departement.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmenetController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside saveDepartment method of DepartmenetController ");
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long departmentId) {
		log.info("Inside findDepartmentById method of DepartmenetController ");
		Optional<Department> department = departmentService.findDepartmentById(departmentId);
		if (department.isPresent()) {
			return department.get();
		} else {
			return null;
		}

	}

	@DeleteMapping("/{id}")
	public void deleteDepartmentById(@PathVariable("id") Long departmentId) {
		log.info("Inside deleteDepartmentById method of DepartmenetController ");
		departmentService.deleteDepartmenetById(departmentId);
	}
}
