package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.domain.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

}
