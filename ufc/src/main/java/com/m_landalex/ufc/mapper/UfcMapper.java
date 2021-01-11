package com.m_landalex.ufc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Ufc;
import com.m_landalex.ufc.domain.UfcEntity;

@Component
public class UfcMapper extends AbstractMapper<Ufc, UfcEntity> {

	public UfcMapper(ModelMapper modelMapper, Class<Ufc> dtoClass, Class<UfcEntity> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
