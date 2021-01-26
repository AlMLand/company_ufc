package com.m_landalex.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.Fighter;
import com.m_landalex.ufc.mapper.FighterMapper;
import com.m_landalex.ufc.persistence.FighterRepository;

@Transactional
@Service
public class FighterService {
	
	@Autowired(required = false)
	private FighterRepository fighterRepository;
	@Autowired(required = false)
	private FighterMapper fighterMapper;
	
	@Transactional(propagation = Propagation.NEVER)
	public long countAll() {
		return fighterRepository.countAll();
	}
	
	@Transactional(readOnly = true)
	public List<Fighter> fetchAll(){
		return fighterMapper.toDTOList(fighterRepository.findAll());
	}
	
	public Fighter save(Fighter fighter) {
		fighterRepository.save(fighterMapper.toEntity(fighter));
		return fighter;
	}
	
}
