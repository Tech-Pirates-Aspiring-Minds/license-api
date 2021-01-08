package com.kg.licence.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kg.licence.model.AuditUserData;
import com.kg.licence.model.LicenceDetail;
import com.kg.licence.model.SessionDetail;
import com.kg.licence.model.UserTrack;

@Service
public class SessionLimitService implements ISessionLimitService {

	private Map<String, Long> sessionCounter = new HashMap<>();

	@Autowired
	private ILicenceService licenceService;

	@Autowired
	private IUserTrackService auditService;

	@Override
	public SessionDetail getSessionCountByKey(String keyStr) {
		String key = getOrginalKey(keyStr);

		SessionDetail detail = new SessionDetail();
		detail.setValid(false);
		detail.setUsedTokens(0);
		detail.setActualTokens(0);

		LicenceDetail licence = licenceService.getLicence(key);
		if (licence != null) {
			try {
				long actualTokens = licence.getTokens();
				long usedTokens = sessionCounter.containsKey(key) ? sessionCounter.get(key) : 0;

				detail.setActualTokens(actualTokens);
				detail.setUsedTokens(usedTokens);
				if (actualTokens > usedTokens) {
					detail.setValid(true);
					return detail;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return detail;

	}

	private boolean audit(AuditUserData data) {
		UserTrack track = null;
		if (data.isLogIn()) {
			track = new UserTrack();
			track.setUser(data.getUserId());
			track.setIpAddress(data.getIpAddress());
			track.setLoggedIn(new Date());
			track.setSessionId(data.getSessionId());
			track.setOs(data.getOs());
			track.setBrowser(data.getBrowser());
			track.setLicenceId(data.getLicenceId());
			/**
			 * mobile device detail
			 */
			track.setAppId(data.getAppId());
			track.setDeviceId(data.getDeviceId());
			track.setDeviceModel(data.getDeviceId());
			track.setDeviceOSVersion(data.getDeviceOSVersion());
			track.setDeviceType(data.getDeviceType());

			auditService.saveTrack(track);
		} else {
			track = auditService.findBySession(data.getSessionId());
			if (track != null) {
				track.setLoggedOut(new Date());
				auditService.updateTrack(track);
			}
		}
		return true;
	}

	@Override
	public boolean trackUser(String keyStr, AuditUserData reqData) {
		String key = getOrginalKey(keyStr);
		if (reqData.isLogIn()) {
			LicenceDetail licence = licenceService.getLicence(key);
			if (licence != null) {
				try {
					long actualTokens = licence.getTokens();
					long usedTokens = sessionCounter.containsKey(key) ? sessionCounter.get(key) : 0;

					reqData.setLicenceId(licence.getId());

					if (actualTokens > usedTokens) {
						audit(reqData);
						long addedTokens = usedTokens + 1;
						sessionCounter.put(key, addedTokens);
						return true;

					}
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}
			}
		} else {
			if (sessionCounter.containsKey(key)) {
				long usedTokens = sessionCounter.get(key) - 1;
				audit(reqData);
				if (usedTokens >= 0) {
					sessionCounter.put(key, usedTokens);
				}
			}
			return true;
		}

		return false;
	}

	@Override
	public boolean validateLicenceExpiry(String keyStr) {
		String key = getOrginalKey(keyStr);
		LicenceDetail licence = licenceService.getLicence(key);

		if (licence != null && licence.getRegistration() == 1 && licence.getStatus() == 1
				&& licence.getExpiry().compareTo(new Date()) >= 0) {
			if (sessionCounter.containsKey(key)) {
				sessionCounter.put(key, 0L);
			}
			return true;
		}
		return false;
	}
	
	private String getOrginalKey(String key) {
		return key.replace("__", "/");
	}

}
