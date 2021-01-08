package com.kg.licence.service;

import com.kg.licence.model.AuditUserData;
import com.kg.licence.model.SessionDetail;

public interface ISessionLimitService {
	
	SessionDetail getSessionCountByKey(String key);

	boolean trackUser(String key, AuditUserData licence);

	boolean validateLicenceExpiry(String key);
}
