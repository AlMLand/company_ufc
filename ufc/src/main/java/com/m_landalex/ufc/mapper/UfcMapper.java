package com.m_landalex.ufc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Ufc;
import com.m_landalex.ufc.domain.UfcEntity;

@Component
public class UfcMapper extends AbstractMapper<Ufc, UfcEntity> {

	@Autowired
	public UfcMapper() {
		super(Ufc.class, UfcEntity.class);
	}

}
