package com.m_landalex.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.Fight;
import com.m_landalex.ufc.mapper.FightMapper;
import com.m_landalex.ufc.persistence.FightRepository;

@Transactional
@Service
public class FightService {
	
	@Autowired
	private FightRepository fightRepository;
	@Autowired
	private FightMapper fightMapper;
	
	@Transactional(readOnly = true)
	public List<Fight> fetchAll(){
		return fightMapper.toDTOList(fightRepository.findAll());
	}
	
	public Fight save(Fight fight) {
		fightRepository.save(fightMapper.toEntity(fight));
		return fight;
	}
	
}
