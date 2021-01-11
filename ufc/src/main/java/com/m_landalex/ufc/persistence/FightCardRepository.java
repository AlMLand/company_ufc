package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.data.FightCard;

public interface FightCardRepository extends JpaRepository<FightCard, Long> {

}
