package com.m_landalex.ufc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Fight;
import com.m_landalex.ufc.domain.FighterEntity;

@Component
public class FightMapper extends AbstractMapper<Fight, FighterEntity> {

	public FightMapper(ModelMapper modelMapper, Class<Fight> dtoClass, Class<FighterEntity> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
