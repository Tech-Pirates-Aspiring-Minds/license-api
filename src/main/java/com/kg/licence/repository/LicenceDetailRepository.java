package com.kg.licence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kg.licence.model.LicenceDetail;

@Repository
public interface LicenceDetailRepository extends JpaRepository<LicenceDetail, Integer> {
	
	LicenceDetail findByKey(String key);

}
