package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.data.PreliminaryCard;

public interface PreliminaryCardRepository extends JpaRepository<PreliminaryCard, Long> {

}
