package com.m_landalex.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.Ufc;
import com.m_landalex.ufc.mapper.UfcMapper;
import com.m_landalex.ufc.persistence.UfcRepository;

@Transactional
@Service
public class UfcService {

	@Autowired
	private UfcRepository ufcRepository;
	@Autowired
	private UfcMapper ufcMapper;
	
	@Transactional(readOnly = true)
	public List<Ufc> fetchAll(){
		return ufcMapper.toDTOList(ufcRepository.findAll());
	}
	
	public Ufc save(Ufc ufc) {
		ufcRepository.save(ufcMapper.toEntity(ufc));
		return ufc;
	}
	
}
