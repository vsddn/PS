package com.sapient.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.date_time_calculator.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

	  @Query(value="SELECT session_id FROM session ORDER BY session_id DESC LIMIT 1", nativeQuery = true)
	    Long findSessionId();
	
}


