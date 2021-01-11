package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.data.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
