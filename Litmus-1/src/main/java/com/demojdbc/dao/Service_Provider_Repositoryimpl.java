package com.demojdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demojdbc.entity.Service_Provider;

@Repository
public class Service_Provider_Repositoryimpl {

	 private static final String INSERT_Service_Provider_QUERY = "INSERT INTO Service_Provider(hr_id,status,remarks,cancel_reason,current_date) values(?,?,?,?,?)";
	 private static final String UPDATE_Service_Provider_BY_ID_QUERY = "UPDATE Service_Provider SET fname=? WHERE ID=?";
	 private static final String GET_Service_Provider_BY_ID_QUERY = "SELECT * FROM Service_Provider WHERE ID=?";
	 private static final String DELETE_Service_Provider_BY_ID = "DELETE FROM Service_Provider WHERE ID=?";
	 private static final String GET_Service_Providers_QUERY = "SELECT * FROM Service_Provider";
	 
	 @Autowired
	 private JdbcTemplate jdbcTemplate;
	 
	
	 public Service_Provider saveService_Provider(Service_Provider service_provider) {
			jdbcTemplate.update(INSERT_Service_Provider_QUERY,service_provider.getHr_id(), service_provider.getStatus(), service_provider.getRemarks(), service_provider.getCancel_reason(), service_provider.getCurrent_date());
				return service_provider;                            
	 }
 
	
	public Service_Provider updateService_Provider(Service_Provider service_provider) {
		 jdbcTemplate.update(UPDATE_Service_Provider_BY_ID_QUERY, service_provider.getStatus(), service_provider.getHr_id(),service_provider.getRemarks(), service_provider.getCancel_reason(), service_provider.getCurrent_date());
		   return service_provider;
		}

	
	public Service_Provider getByHr_id(int hr_id) {
	 return jdbcTemplate.queryForObject(GET_Service_Provider_BY_ID_QUERY, (rs, rowNum) -> {

          return new Service_Provider(rs.getInt("hr_id"), rs.getString("status"), rs.getString("remarks"), rs.getString("cancel_reason"),rs.getInt("current_date"));
		        },hr_id);
		}

	
		public List<Service_Provider> allService_Provider() {
		     return jdbcTemplate.query(GET_Service_Providers_QUERY, (rs, rowNum) -> {
		            return new Service_Provider(rs.getInt("hr_id"), rs.getString("status"), rs.getString("remarks"), rs.getString("cancel_reason"),rs.getInt("current_date"));
		        });
		}

}
