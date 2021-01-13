package com.m_landalex.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.Trainingteam;
import com.m_landalex.ufc.mapper.TrainingteamMapper;
import com.m_landalex.ufc.persistence.TrainingteamRepository;

@Transactional
@Service
public class TrainingteamService {

	@Autowired
	private TrainingteamRepository trainingteamRepository;
	@Autowired
	private TrainingteamMapper trainingteamMapper;
	
	@Transactional(readOnly = true)
	public List<Trainingteam> fetchAll(){
		return trainingteamMapper.toDTOList(trainingteamRepository.findAll());
	}
	
}