package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.domain.MainCardEntity;

public interface MainCardRepository extends JpaRepository<MainCardEntity, Long> {

}
