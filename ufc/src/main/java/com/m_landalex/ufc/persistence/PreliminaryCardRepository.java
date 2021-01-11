package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.domain.PreliminaryCardEntity;

public interface PreliminaryCardRepository extends JpaRepository<PreliminaryCardEntity, Long> {

}
