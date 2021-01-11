package com.m_landalex.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.Address;
import com.m_landalex.ufc.mapper.AddressMapper;
import com.m_landalex.ufc.persistence.AddressRepository;

@Transactional
@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private AddressMapper addressMapper;
	
	@Transactional(readOnly = true)
	private List<Address> fetchAll(){
		return addressMapper.toDTOList(addressRepository.findAll());
	}
	
}
