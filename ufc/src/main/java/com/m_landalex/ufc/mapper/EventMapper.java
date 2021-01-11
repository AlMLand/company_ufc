package com.m_landalex.ufc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Event;
import com.m_landalex.ufc.domain.EventEntity;

@Component
public class EventMapper extends AbstractMapper<Event, EventEntity> {

	@Autowired
	public EventMapper(ModelMapper modelMapper, Class<Event> dtoClass, Class<EventEntity> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
