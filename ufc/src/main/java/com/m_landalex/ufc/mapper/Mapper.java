package com.m_landalex.ufc.mapper;

import java.util.List;

import com.m_landalex.ufc.data.AbstractObject;
import com.m_landalex.ufc.domain.AbstractEntity;

public interface Mapper <S extends AbstractObject, E extends AbstractEntity> {

	E toEntity(S dto);
	S toDTO(E entity);
	List<S> toDTOList(List<E> entityList);
	List<E> toEntityList(List<S> dtoList);
	
}
