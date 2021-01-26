package com.m_landalex.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.MainCard;
import com.m_landalex.ufc.mapper.MainCardMapper;
import com.m_landalex.ufc.persistence.MainCardRepository;

@Transactional
@Service
public class MainCardService {
	
	@Autowired(required = false)
	private MainCardRepository mainCardRepository;
	@Autowired(required = false)
	private MainCardMapper mainCardMapper;
	
	@Transactional(readOnly = true)
	public List<MainCard> fetchAll(){
		return mainCardMapper.toDTOList(mainCardRepository.findAll());
	}
	
	public MainCard save(MainCard mainCard) {
		mainCardRepository.save(mainCardMapper.toEntity(mainCard));
		return mainCard;
	}
	
}
