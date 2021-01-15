package com.m_landalex.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.UfcInterEmployee;
import com.m_landalex.ufc.mapper.UfcInternEmployeeMapper;
import com.m_landalex.ufc.persistence.UfcInternEmployeeRepository;

@Transactional
@Service
public class UfcInternEmployeeService {
	
	@Autowired
	private UfcInternEmployeeRepository ufcInternEmployeeRepository;
	@Autowired
	private UfcInternEmployeeMapper ufcInternEmployeeMapper;
	
	@Transactional(readOnly = true)
	public List<UfcInterEmployee> fetchAll(){
		return ufcInternEmployeeMapper.toDTOList(ufcInternEmployeeRepository.findAll());
	}
	
	public UfcInterEmployee save(UfcInterEmployee ufcInterEmployee) {
		ufcInternEmployeeRepository.save(ufcInternEmployeeMapper.toEntity(ufcInterEmployee));
		return ufcInterEmployee;
	}
	
}
