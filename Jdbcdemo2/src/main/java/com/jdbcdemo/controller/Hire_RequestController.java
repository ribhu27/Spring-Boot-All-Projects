package com.jdbcdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdbcdemo.dao.Hire_RequestRepository;
import com.jdbcdemo.dao.Hire_RequestRepositoryImpl;
import com.jdbcdemo.entity.Hire_Request;

@RestController
public class Hire_RequestController {

	 @Autowired
	 Hire_RequestRepositoryImpl hire_requestRepository;
	 
	   @PostMapping("/hire_request")
	    public Hire_Request addHire_Request(@RequestBody Hire_Request hire_request) {

	        return hire_requestRepository.saveHire_Request(hire_request);
	    }

	    @PutMapping("/service_provider/update_hire_request_status")
	    public Hire_Request updateHire_Request(@RequestBody Hire_Request hire_request) {

	        return hire_requestRepository.updateHire_Request(hire_request);

	    }

	    @GetMapping("/service_provider/get_all_hire_request/{hr_id}")
	    public Hire_Request getHire_Request(@PathVariable("hr_id") int hr_id) {
	        return hire_requestRepository.getByHr_id(hr_id);
	    }

	    @GetMapping("/service_provider/get_all_hire_request")
	    public List<Hire_Request> getHire_Requests() {
	        return hire_requestRepository.allHire_Requests();
	    }

	    @DeleteMapping("/hire_request/{hr_id}")
	    public String deleteHire_Request(@PathVariable("hr_id") int hr_id){
	        return hire_requestRepository.deleteByHr_id(hr_id);
	    }

}