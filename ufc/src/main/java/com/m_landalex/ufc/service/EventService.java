package com.m_landalex.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.Event;
import com.m_landalex.ufc.mapper.EventMapper;
import com.m_landalex.ufc.persistence.EventRepository;

@Transactional(transactionManager = "")
@Service
public class EventService {
	
	@Autowired(required = false)
	private EventRepository eventRepository;
	@Autowired(required = false)
	private EventMapper eventMapper;
	
	@Transactional(readOnly = true)
	public List<Event> fetchAll(){
		return eventMapper.toDTOList(eventRepository.findAll());
	}
	
	public Event save(Event event) {
		eventRepository.save(eventMapper.toEntity(event));
		return event;
	}
	
}
