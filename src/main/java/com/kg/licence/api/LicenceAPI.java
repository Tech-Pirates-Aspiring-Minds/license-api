package com.kg.licence.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kg.licence.model.AuditUserData;
import com.kg.licence.model.RegisterData;
import com.kg.licence.model.SessionDetail;
import com.kg.licence.service.ILicenceService;
import com.kg.licence.service.ISessionLimitService;

@RestController
@RequestMapping("/api/licence")
public class LicenceAPI {

	@Autowired
	private ILicenceService licenceService;

	@Autowired
	private ISessionLimitService sessionCounter;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public boolean register(@RequestBody RegisterData data) {
		return licenceService.register(data);
	}

	@RequestMapping(value = "/{key}/user", method = RequestMethod.GET)
	public SessionDetail getSessionCountByKey(@PathVariable String key) {
		return sessionCounter.getSessionCountByKey(key);
	}

	@RequestMapping(value = "/{key}/user", method = RequestMethod.POST)
	public boolean trackUser(@PathVariable String key, @RequestBody AuditUserData data) {
		return sessionCounter.trackUser(key, data);
	}

	@RequestMapping(value = "/{key}/key-expiry", method = RequestMethod.GET)
	public boolean validateLicenceExpiry(@PathVariable String key) {
		return sessionCounter.validateLicenceExpiry(key);
	}

}
