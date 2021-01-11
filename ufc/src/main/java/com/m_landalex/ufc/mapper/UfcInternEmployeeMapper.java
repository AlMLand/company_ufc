package com.m_landalex.ufc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.UfcInterEmployee;
import com.m_landalex.ufc.domain.UfcInternEmployeeEntity;

@Component
public class UfcInternEmployeeMapper extends AbstractMapper<UfcInterEmployee, UfcInternEmployeeEntity> {

	public UfcInternEmployeeMapper(ModelMapper modelMapper, Class<UfcInterEmployee> dtoClass,
			Class<UfcInternEmployeeEntity> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
