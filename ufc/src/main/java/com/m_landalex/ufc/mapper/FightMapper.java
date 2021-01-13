package com.m_landalex.ufc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Fight;
import com.m_landalex.ufc.domain.FightEntity;

@Component
public class FightMapper extends AbstractMapper<Fight, FightEntity> {

	@Autowired
	public FightMapper() {
		super(Fight.class, FightEntity.class);
	}

}
