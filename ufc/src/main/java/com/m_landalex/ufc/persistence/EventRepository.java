package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.data.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
