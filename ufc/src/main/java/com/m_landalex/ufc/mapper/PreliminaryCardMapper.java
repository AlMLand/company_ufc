package com.m_landalex.ufc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.PreliminaryCard;
import com.m_landalex.ufc.domain.PreliminaryCardEntity;

@Component
public class PreliminaryCardMapper extends AbstractMapper<PreliminaryCard, PreliminaryCardEntity> {

	public PreliminaryCardMapper(ModelMapper modelMapper, Class<PreliminaryCard> dtoClass,
			Class<PreliminaryCardEntity> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
