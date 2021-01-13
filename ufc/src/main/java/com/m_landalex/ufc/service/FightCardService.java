package com.m_landalex.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.FightCard;
import com.m_landalex.ufc.mapper.FightCardMapper;
import com.m_landalex.ufc.persistence.FightCardRepository;

@Transactional
@Service
public class FightCardService {

	@Autowired
	private FightCardRepository fightCardRepository;
	@Autowired
	private FightCardMapper fightCardMapper;
	
	@Transactional(readOnly = true)
	public List<FightCard> fetchAll(){
		return fightCardMapper.toDTOList(fightCardRepository.findAll());
	}
	
	public FightCard save(FightCard fightCard) {
		fightCardRepository.save(fightCardMapper.toEntity(fightCard));
		return fightCard;
	}
	
}
