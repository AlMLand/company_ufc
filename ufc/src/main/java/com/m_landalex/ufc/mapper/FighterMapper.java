package com.m_landalex.ufc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Fighter;
import com.m_landalex.ufc.domain.FighterEntity;

@Component
public class FighterMapper extends AbstractMapper<Fighter, FighterEntity> {

	public FighterMapper(ModelMapper modelMapper, Class<Fighter> dtoClass, Class<FighterEntity> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
