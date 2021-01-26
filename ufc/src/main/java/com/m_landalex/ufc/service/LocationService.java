package com.m_landalex.ufc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.Location;
import com.m_landalex.ufc.mapper.LocationMapper;
import com.m_landalex.ufc.persistence.LocationRepository;

@Transactional
@Service
public class LocationService {

	@Autowired(required = false)
	private LocationRepository locationRepository;
	@Autowired(required = false)
	private LocationMapper locationMapper;
	
	@Transactional(readOnly = true)
	public List<Location> fetchAll(){
		return locationMapper.toDTOList(locationRepository.findAll());
	}
	
	public Location save(Location location) {
		locationRepository.save(locationMapper.toEntity(location));
		return location;
	}
	
}
