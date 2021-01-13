package com.m_landalex.ufc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.PreliminaryCard;
import com.m_landalex.ufc.domain.PreliminaryCardEntity;

@Component
public class PreliminaryCardMapper extends AbstractMapper<PreliminaryCard, PreliminaryCardEntity> {

	@Autowired
	public PreliminaryCardMapper() {
		super(PreliminaryCard.class, PreliminaryCardEntity.class);
	}

}
