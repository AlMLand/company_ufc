package com.m_landalex.ufc.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.m_landalex.ufc.data.Location;
import com.m_landalex.ufc.domain.LocationEntity;

@Component
public class LocationMapper extends AbstractMapper<Location, LocationEntity> {

	public LocationMapper(ModelMapper modelMapper, Class<Location> dtoClass, Class<LocationEntity> entityClass) {
		super(modelMapper, dtoClass, entityClass);
	}

}
