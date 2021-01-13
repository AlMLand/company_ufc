package com.m_landalex.ufc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Address;
import com.m_landalex.ufc.domain.AddressEntity;

@Component
public class AddressMapper extends AbstractMapper<Address, AddressEntity> {

	@Autowired
	public AddressMapper() {
		super(Address.class, AddressEntity.class);
	}

}
