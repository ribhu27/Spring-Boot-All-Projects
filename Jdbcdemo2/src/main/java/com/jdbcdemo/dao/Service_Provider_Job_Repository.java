package com.jdbcdemo.dao;

import java.util.List;

import com.jdbcdemo.entity.Hire_Request;
import com.jdbcdemo.entity.Service_Provider_Job;


public interface Service_Provider_Job_Repository {
	Service_Provider_Job saveservice_provider(Service_Provider_Job service_provider);

	Service_Provider_Job updateService_Provider_Job(Service_Provider_Job service_provider);


	Service_Provider_Job getBySp_job_id(int sp_job_id);

    List<Service_Provider_Job> allService_Provider_Jobs();

}