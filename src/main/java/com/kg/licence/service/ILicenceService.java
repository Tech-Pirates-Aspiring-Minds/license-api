package com.kg.licence.service;

import com.kg.licence.model.LicenceDetail;
import com.kg.licence.model.RegisterData;

public interface ILicenceService {
	
	LicenceDetail getLicence(String key);
	
	boolean register(RegisterData licence);
	
	

}
