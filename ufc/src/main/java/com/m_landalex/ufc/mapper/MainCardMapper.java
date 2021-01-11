package com.m_landalex.ufc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.MainCard;
import com.m_landalex.ufc.domain.MainCardEntity;

@Component
public class MainCardMapper extends AbstractMapper<MainCard, MainCardEntity> {

	public MainCardMapper(ModelMapper modelMapper, Class<MainCard> dtoClass, Class<MainCardEntity> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
