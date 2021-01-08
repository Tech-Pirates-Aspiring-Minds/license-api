package com.kg.licence.service;

import com.kg.licence.model.UserTrack;

public interface IUserTrackService {

	void saveTrack(UserTrack data);

	void updateTrack(UserTrack data);

	UserTrack findBySession(String sessionID);
}
