package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.domain.UfcEntity;

public interface UfcRepository extends JpaRepository<UfcEntity, Long> {

}
