package com.m_landalex.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.PreliminaryCard;
import com.m_landalex.ufc.mapper.PreliminaryCardMapper;
import com.m_landalex.ufc.persistence.PreliminaryCardRepository;

@Transactional
@Service
public class PreliminaryCardService {

	@Autowired
	private PreliminaryCardRepository preliminaryCardRepository;
	@Autowired
	private PreliminaryCardMapper preliminaryCardMapper;
	
	@Transactional(readOnly = true)
	public List<PreliminaryCard> fetchAll(){
		return preliminaryCardMapper.toDTOList(preliminaryCardRepository.findAll());
	}
	
	public PreliminaryCard save(PreliminaryCard preliminaryCard) {
		preliminaryCardRepository.save(preliminaryCardMapper.toEntity(preliminaryCard));
		return preliminaryCard;
	}
	
}
