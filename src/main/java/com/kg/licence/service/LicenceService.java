package com.kg.licence.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kg.licence.model.LicenceDetail;
import com.kg.licence.model.RegisterData;

@Service
public class LicenceService implements ILicenceService {

	@Autowired
	private ILicenceStoreService service;

	@PostConstruct
	private void postConstruct() {
	}

	public LicenceDetail getLicenceDetail(String key) {
		return service.fetchById(key);
	}

	public List<LicenceDetail> getAllLicenceDetail() {
		return service.fetchAll();
	}

	@SuppressWarnings("unused")
	private Map<String, LicenceDetail> readLicenceDetail() throws IOException {

		File resource = new ClassPathResource("licence.json").getFile();
		String text = new String(Files.readAllBytes(resource.toPath()));
		JSONArray array = new JSONArray(text);

		Map<String, LicenceDetail> licenceDetailMap = new HashMap<>();
		for (int i = 0; i < array.length(); i++) {
			String object = array.getJSONObject(i).toString();
			LicenceDetail licenceDetail = new ObjectMapper().readValue(object, LicenceDetail.class);
			licenceDetailMap.put(licenceDetail.getKey(), licenceDetail);
		}

		return licenceDetailMap;

	}

	@Override
	public LicenceDetail getLicence(String key) {
		LicenceDetail licence = service.fetchById(key);
		return licence;
	}

	@Override
	public boolean register(RegisterData reqData) {
		String key = reqData.getKey();
		if (!StringUtils.isEmpty(key)) {
			LicenceDetail licence = service.fetchById(key);
			if (licence != null && licence.getRegistration() == 0 && licence.getStatus() == 1 && licence.getExpiry().compareTo(new Date()) >=0 ) {
				licence.setRegistration(1);
				service.updateLicence(licence);
				return true;
			}
		}

		return false;
	}

}
