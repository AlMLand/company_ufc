package com.m_landalex.ufc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.persistence.UfcInternEmployeeRepository;

@Transactional
@Service
public class UfcInternEmployeeService {

	@Autowired
	private UfcInternEmployeeRepository ufcInternEmployeeRepository;
	
}
