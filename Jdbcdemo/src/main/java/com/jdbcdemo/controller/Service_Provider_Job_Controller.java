package com.jdbcdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jdbcdemo.dao.Service_Provider_Job_RepositoryImpl;
import com.jdbcdemo.entity.Hire_Request;
import com.jdbcdemo.entity.Service_Provider_Job;


@RestController
public class Service_Provider_Job_Controller {

	 @Autowired
	 Service_Provider_Job_RepositoryImpl service_provider_jobRepository;
	    

   	    @PostMapping("/service_provider")
	    public Service_Provider_Job addService_Provider_Job(@RequestBody Service_Provider_Job service_provider) {

	        return service_provider_jobRepository.saveService_Provider_Job(service_provider);
	    }

	    @PutMapping("/service_provider")
	    public Service_Provider_Job updateService_Provider_Job(@RequestBody Service_Provider_Job service_provider) {

	        return service_provider_jobRepository.updateService_Provider_Job(service_provider);
	    }
	 
	    @GetMapping("/service_provider/get_upcoming_jobs/get_past_job/{sp_job_id}")
	    public Service_Provider_Job getService_Provider_Job(@PathVariable("sp_job_id") int sp_job_id) {
	        return service_provider_jobRepository.getBySp_job_id(sp_job_id);
	    }
	   
	    @GetMapping("/service_provider/get_all_jobs")
	    public List<Service_Provider_Job> allService_Provider_Jobs() {
	        return service_provider_jobRepository.allService_Provider_Jobs();
	    }
	   
}