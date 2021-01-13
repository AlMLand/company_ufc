package com.m_landalex.ufc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Trainingteam;
import com.m_landalex.ufc.domain.TrainingteamEntity;

@Component
public class TrainingteamMapper extends AbstractMapper<Trainingteam, TrainingteamEntity> {

	@Autowired
	public TrainingteamMapper() {
		super(Trainingteam.class, TrainingteamEntity.class);
	}

}
