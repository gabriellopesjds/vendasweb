package com.gabriellopesjds.vendasweb.domain.converters;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BaseConverter<Entity, Request, Response> {

	private Class<Entity> typeEntity;
	private Class<Response> typeResponse;

	@Autowired
	private ModelMapper modelMapper;

	public BaseConverter(Class<Entity> typeEntity, Class<Response> typeResponse) {
		this.typeEntity = typeEntity;
		this.typeResponse = typeResponse;
	}

	private Class<Entity> getTypeEntity() {
		return this.typeEntity;
	}
	
	private Class<Response> getTypeResponse() {
		return this.typeResponse;
	}

	public Entity toEntity(Request requestDTO) {
		return modelMapper.map(requestDTO, getTypeEntity());
	}
	
	public Response toModel(Entity entity) {
		return modelMapper.map(entity, getTypeResponse());
	}

}
