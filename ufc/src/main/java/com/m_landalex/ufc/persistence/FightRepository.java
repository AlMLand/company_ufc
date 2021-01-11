package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.data.Fight;

public interface FightRepository extends JpaRepository<Fight, Long> {

}
