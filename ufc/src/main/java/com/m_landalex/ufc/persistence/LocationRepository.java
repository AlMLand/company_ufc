package com.m_landalex.ufc.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m_landalex.ufc.domain.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

}
