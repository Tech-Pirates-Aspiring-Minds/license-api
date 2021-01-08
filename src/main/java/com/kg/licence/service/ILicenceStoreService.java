package com.kg.licence.service;

import java.util.List;

import com.kg.licence.model.LicenceDetail;

public interface ILicenceStoreService {
	
	LicenceDetail fetchById(String key);
	
	List<LicenceDetail> fetchAll();
	
	void updateLicence(LicenceDetail detail);

}
