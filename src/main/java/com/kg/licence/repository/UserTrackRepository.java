package com.kg.licence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kg.licence.model.UserTrack;

@Repository
public interface UserTrackRepository extends JpaRepository<UserTrack, Long> {

	public List<UserTrack> findBySessionId(String sessionId);

}
