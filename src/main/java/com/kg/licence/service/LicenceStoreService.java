package com.kg.licence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.licence.model.LicenceDetail;
import com.kg.licence.repository.LicenceDetailRepository;

@Service
public class LicenceStoreService implements ILicenceStoreService {

	@Autowired
	private LicenceDetailRepository repository;

	public void saveLicence(LicenceDetail data) {
		repository.save(data);
	}

	public void updateLicence(LicenceDetail data) {
		repository.save(data);
	}

	public List<LicenceDetail> fetchAll() {
		return repository.findAll();
	}

	public LicenceDetail fetchById(String key) {
		LicenceDetail data = repository.findByKey(key);

		return data;
	}

}
