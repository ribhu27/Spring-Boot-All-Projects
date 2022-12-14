package com.demojdbc.dao;

import java.util.List;

import com.demojdbc.entity.Service_Provider;

public interface Service_Provider_Repository {
	Service_Provider saveservice_provider(Service_Provider service_provider);

	Service_Provider updateService_Provider(Service_Provider service_provider);

	Service_Provider getByHr_d(int hr_id);

    String deleteByHr_d(int hr_id);

    List<Service_Provider> allService_Provider();

}
