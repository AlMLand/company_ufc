package com.m_landalex.ufc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.persistence.FightCardRepository;

@Transactional
@Service
public class FightCardService {

	@Autowired
	private FightCardRepository fightCardRepository;
	
}
