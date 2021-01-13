package com.m_landalex.ufc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.MainCard;
import com.m_landalex.ufc.domain.MainCardEntity;

@Component
public class MainCardMapper extends AbstractMapper<MainCard, MainCardEntity> {

	@Autowired
	public MainCardMapper() {
		super(MainCard.class, MainCardEntity.class);
	}

}
