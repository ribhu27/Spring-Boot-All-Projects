package com.demojdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demojdbc.dao.Service_Provider_Repositoryimpl;
import com.demojdbc.entity.Service_Provider;


@RestController
public class Service_Provider_Controller {
	@Autowired
	Service_Provider_Repositoryimpl service_provider_Repository;
	
	@PostMapping("/user")
    public Service_Provider addService_Provider(@RequestBody Service_Provider service_provider) {
        return service_provider_Repository.saveService_Provider(service_provider);
    }

    @PutMapping("/user")
    public Service_Provider updateService_Provider(@RequestBody Service_Provider service_provider) {
        return service_provider_Repository.updateService_Provider(service_provider);

    }

    @GetMapping("/user/{id}")
    public Service_Provider getService_Provider(@PathVariable("hr_id") int hr_id) {
        return service_provider_Repository.getByHr_id(hr_id);
    }

    @GetMapping("/users")
    public List<Service_Provider> getService_Providers() {
        return service_provider_Repository.allService_Provider();
    }

//    @DeleteMapping("/user/{id}")
//    public String deleteService_Provider(@PathVariable("hr_id") int hr_id){
//        return service_provider_Repository.deleteById(hr_id);
//    }
}
