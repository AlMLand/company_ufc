package com.m_landalex.ufc.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;

import com.m_landalex.ufc.data.AbstractObject;
import com.m_landalex.ufc.domain.AbstractEntity;

public abstract class AbstractMapper<S extends AbstractObject, E extends AbstractEntity> implements Mapper<S, E> {

	private ModelMapper modelMapper;
	private Class<S> dtoClass;
	private Class<E> entityClass;

	public AbstractMapper(ModelMapper modelMapper, Class<S> dtoClass, Class<E> entityClass) {
		super();
		this.modelMapper = modelMapper;
		this.dtoClass = dtoClass;
		this.entityClass = entityClass;
	}

	@Override
	public E toEntity(S dto) {
		return Objects.isNull(dto) ? null : modelMapper.map(dto, entityClass);
	}

	@Override
	public S toDTO(E entity) {
		return Objects.isNull(entity) ? null : modelMapper.map(entity, dtoClass);
	}

	@Override
	public List<S> toDTOList(List<E> entityList) {
		return Objects.isNull(entityList) ? null : entityList.stream()
				.map(entity -> modelMapper.map(entity, dtoClass))
				.collect(Collectors.toList());
	}

	@Override
	public List<E> toEntityList(List<S> dtoList) {
		return Objects.isNull(dtoList) ? null : dtoList.stream()
				.map(dto -> modelMapper.map(dto, entityClass))
				.collect(Collectors.toList());
	}
	
	protected Converter<S, E> converterToEntity(){
		return context -> {
			S source = context.getSource();
			E destination = context.getDestination();
			mapSpecificField(source, destination);
			return context.getDestination();
		};
	}

	protected void mapSpecificField(S source, E destination) {
		
	}

	protected Converter<E, S> converterToDTO(){
		return context -> {
			E source = context.getSource();
			S destination = context.getDestination();
			mapSpecificField(source, destination);
			return context.getDestination();
		};
	}

	protected void mapSpecificField(E source, S destination) {
		
	}
	
}
