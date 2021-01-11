package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.domain.FightEntity;

public interface FightRepository extends JpaRepository<FightEntity, Long> {

}
