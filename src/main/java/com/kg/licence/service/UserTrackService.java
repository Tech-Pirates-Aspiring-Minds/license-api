package com.kg.licence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.licence.model.UserTrack;
import com.kg.licence.repository.UserTrackRepository;

@Service
public class UserTrackService implements IUserTrackService {

	@Autowired
	private UserTrackRepository repository;

	public void saveTrack(UserTrack audit) {
		repository.save(audit);
	}

	public UserTrack findBySession(String sessionID) {
		List<UserTrack> data = repository.findBySessionId(sessionID);
		if (data != null && !data.isEmpty()) {
			return data.get(0);
		}
		return null;
	}
	
	public void updateTrack(UserTrack audit) {
		repository.save(audit);
	}


}
