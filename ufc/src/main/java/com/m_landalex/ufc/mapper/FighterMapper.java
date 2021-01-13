package com.m_landalex.ufc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Fighter;
import com.m_landalex.ufc.domain.FighterEntity;

@Component
public class FighterMapper extends AbstractMapper<Fighter, FighterEntity> {

	@Autowired
	public FighterMapper() {
		super(Fighter.class, FighterEntity.class);
	}

}
