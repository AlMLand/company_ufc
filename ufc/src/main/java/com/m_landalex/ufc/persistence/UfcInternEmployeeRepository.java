package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.domain.UfcInternEmployeeEntity;

public interface UfcInternEmployeeRepository extends JpaRepository<UfcInternEmployeeEntity, Long> {

}
