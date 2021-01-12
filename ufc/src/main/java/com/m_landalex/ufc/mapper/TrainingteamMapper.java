package com.m_landalex.ufc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Trainingteam;
import com.m_landalex.ufc.domain.TrainingteamEntity;

@Component
public class TrainingteamMapper extends AbstractMapper<Trainingteam, TrainingteamEntity> {

	public TrainingteamMapper(ModelMapper modelMapper, Class<Trainingteam> dtoClass,
			Class<TrainingteamEntity> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
