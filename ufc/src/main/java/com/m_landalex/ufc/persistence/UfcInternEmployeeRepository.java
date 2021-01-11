package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.data.UfcInterEmployee;

public interface UfcInternEmployeeRepository extends JpaRepository<UfcInterEmployee, Long> {

}
