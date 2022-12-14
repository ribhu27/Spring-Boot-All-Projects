package com.jdbcdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Service_Provider_Job {
	private int sp_job_id;
	private String job_title;
	private int sp_id;
    private int service_id;
    private int customer_id;
	private String location;
	private String status;
	private String job_date_time;
	private  int pet_id  ;
    private String remarks;
    private String cancel_reason;
}