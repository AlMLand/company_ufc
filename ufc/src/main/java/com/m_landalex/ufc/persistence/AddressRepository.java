package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.domain.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Long> {

}
