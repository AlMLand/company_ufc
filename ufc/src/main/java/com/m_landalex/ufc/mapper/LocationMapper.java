package com.m_landalex.ufc.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Location;
import com.m_landalex.ufc.domain.LocationEntity;

@Component
public class LocationMapper extends AbstractMapper<Location, LocationEntity> {

	@Autowired
	public LocationMapper() {
		super(Location.class, LocationEntity.class);
	}

}
