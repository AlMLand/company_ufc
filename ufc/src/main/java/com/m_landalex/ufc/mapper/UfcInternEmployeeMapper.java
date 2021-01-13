package com.m_landalex.ufc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.UfcInterEmployee;
import com.m_landalex.ufc.domain.UfcInternEmployeeEntity;

@Component
public class UfcInternEmployeeMapper extends AbstractMapper<UfcInterEmployee, UfcInternEmployeeEntity> {

	@Autowired
	public UfcInternEmployeeMapper() {
		super(UfcInterEmployee.class, UfcInternEmployeeEntity.class);
	}

}
