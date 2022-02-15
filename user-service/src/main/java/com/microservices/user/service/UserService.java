package com.microservices.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.user.entity.User;
import com.microservices.user.repository.UserRepository;
import com.microservices.user.vo.Department;
import com.microservices.user.vo.ResponseTemplateVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("Inside saveUser of UserService");
		return userRepository.save(user);
	}

	public ResponseTemplateVo getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment of UserService");
		ResponseTemplateVo responseTemplateVo = new ResponseTemplateVo();
		User user = userRepository.findByUserId(userId);

		Department department = restTemplate.getForObject("http://localhost:9001/departments/" + user.getDepartmentId(),
				Department.class);

		responseTemplateVo.setUser(user);
		responseTemplateVo.setDepartment(department);
		return responseTemplateVo;
	}

}
