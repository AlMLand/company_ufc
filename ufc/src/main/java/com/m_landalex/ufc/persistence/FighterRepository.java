package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.domain.FighterEntity;

public interface FighterRepository extends JpaRepository<FighterEntity, Long> {

}
