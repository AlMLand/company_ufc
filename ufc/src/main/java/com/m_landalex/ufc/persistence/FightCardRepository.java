package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.domain.FightCardEntity;

public interface FightCardRepository extends JpaRepository<FightCardEntity, Long> {

}
