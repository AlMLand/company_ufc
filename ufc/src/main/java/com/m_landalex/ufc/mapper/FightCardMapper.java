package com.m_landalex.ufc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.FightCard;
import com.m_landalex.ufc.domain.FightCardEntity;

@Component
public class FightCardMapper extends AbstractMapper<FightCard, FightCardEntity> {

	public FightCardMapper(ModelMapper modelMapper, Class<FightCard> dtoClass, Class<FightCardEntity> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
