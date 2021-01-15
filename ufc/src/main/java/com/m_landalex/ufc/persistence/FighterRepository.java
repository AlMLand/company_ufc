package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.m_landalex.ufc.domain.FighterEntity;

public interface FighterRepository extends JpaRepository<FighterEntity, Long> {

	@Query("SELECT count(f) FROM FighterEntity f")
	long countAll();
	
}
