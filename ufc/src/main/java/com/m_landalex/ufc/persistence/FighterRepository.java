package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.data.Fighter;

public interface FighterRepository extends JpaRepository<Fighter, Long> {

}
