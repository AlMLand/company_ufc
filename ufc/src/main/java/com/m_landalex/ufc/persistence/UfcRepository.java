package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.data.Ufc;

public interface UfcRepository extends JpaRepository<Ufc, Long> {

}
