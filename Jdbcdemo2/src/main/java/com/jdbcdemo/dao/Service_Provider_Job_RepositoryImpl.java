package com.jdbcdemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.jdbcdemo.entity.Hire_Request;
import com.jdbcdemo.entity.Service_Provider_Job;

@Repository
public class Service_Provider_Job_RepositoryImpl {
    
	private static final String INSERT_Service_Provider_Job_QUERY = "INSERT INTO Service_Provider_Job(sp_job_id,job_title,sp_id,service_id,customer_id,location,status,job_date_time,pet_id,remarks,cancel_reason) values(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_Service_Provider_Job_BY_SP_JOB_ID_QUERY = "UPDATE Service_Provider_Job SET job_title=?,sp_id=?,service_id=?,customer_id=?,location=?,status=?,job_date_time=?,pet_id=?,remarks=?,cancel_reason WHERE SP_JOB_ID=?";
    private static final String GET_Service_Provider_Job_BY_SP_JOB_ID_QUERY ="SELECT *FROM Service_Provider_Job WHERE SP_JOB_ID=?";
    private static final String GET_Service_Provider_Jobs_QUERY = "SELECT * FROM Service_Provider_Job";

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Service_Provider_Job saveService_Provider_Job(Service_Provider_Job service_provider) {
		jdbcTemplate.update(INSERT_Service_Provider_Job_QUERY,service_provider.getSp_job_id(), service_provider.getJob_title(), service_provider.getSp_id(), service_provider.getService_id(),service_provider.getCustomer_id(),service_provider.getLocation(),service_provider.getStatus(),service_provider.getJob_date_time(),service_provider.getPet_id(),service_provider.getRemarks(),service_provider.getCancel_reason());
		return service_provider;
	}

	
	public Service_Provider_Job updateService_Provider_Job(Service_Provider_Job service_provider) {
		jdbcTemplate.update(UPDATE_Service_Provider_Job_BY_SP_JOB_ID_QUERY,service_provider.getJob_title(), service_provider.getSp_id(), service_provider.getService_id(),service_provider.getCustomer_id(),service_provider.getLocation(),service_provider.getStatus(),service_provider.getJob_date_time(),service_provider.getPet_id(),service_provider.getRemarks(),service_provider.getCancel_reason(), service_provider.getSp_job_id());
        return service_provider; 
	}
	
	public Service_Provider_Job getBySp_job_id(int sp_job_id) {
		return jdbcTemplate.queryForObject(GET_Service_Provider_Job_BY_SP_JOB_ID_QUERY, (rs, rowNum) -> {
   
	    return new Service_Provider_Job(rs.getInt("sp_job_id"),rs.getString("job_title"),rs.getInt("sp_id"),rs.getInt("service_id"),rs.getInt("customer_id"),rs.getString("location"),rs.getString("status"),rs.getString("job_date_time"),rs.getInt("pet_id"),rs.getString("remarks"),rs.getString("cancel_reason"));
        },sp_job_id);
	}

	public List<Service_Provider_Job> allService_Provider_Jobs() {
		return jdbcTemplate.query(GET_Service_Provider_Jobs_QUERY, (rs, rowNum) -> {
			 return new Service_Provider_Job(rs.getInt("sp_job_id"),rs.getString("job_title"),rs.getInt("sp_id"),rs.getInt("service_id"),rs.getInt("customer_id"),rs.getString("location"),rs.getString("status"),rs.getString("job_date_time"),rs.getInt("pet_id"),rs.getString("remarks"),rs.getString("cancel_reason"));
        });
	}

}