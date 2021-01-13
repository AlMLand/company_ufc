package com.m_landalex.ufc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.FightCard;
import com.m_landalex.ufc.domain.FightCardEntity;

@Component
public class FightCardMapper extends AbstractMapper<FightCard, FightCardEntity> {

	@Autowired
	public FightCardMapper() {
		super(FightCard.class, FightCardEntity.class);
	}

}
