package com.m_landalex.ufc.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "address")
public class AddressEntity extends AbstractEntity {

	@Setter
	private String city;
	@Setter
	private String street;
	@Setter
	private String houseNumber;
	@Setter
	private String postCode;
	
	@Setter
	@OneToOne(mappedBy = "ufcAddress")
	private UfcEntity ufcEntity;
	
	@OneToMany(mappedBy = "address")
	private List<TrainingteamEntity> trainingteams;
	
	@OneToMany(mappedBy = "address")
	private List<UfcInternEmployeeEntity> ufcInternEmployeeEntities;
	
	@OneToMany(mappedBy = "address")
	private List<LocationEntity> locationEntities;
	
	public void setUfcInternEmployeeEntities(List<UfcInternEmployeeEntity> ufcInternEmployeeEntities) {
		ufcInternEmployeeEntities.forEach(ufcInternEmployee -> ufcInternEmployee.setAddress(this));
		this.ufcInternEmployeeEntities = ufcInternEmployeeEntities;
	}
	
	public void addUfcInternEmployeeEntity(UfcInternEmployeeEntity ufcInternEmployeeEntity) {
		this.ufcInternEmployeeEntities.add(ufcInternEmployeeEntity);
		ufcInternEmployeeEntity.setAddress(this);
	}

	public void setLocationEntities(List<LocationEntity> locationEntities) {
		locationEntities.forEach(locationEntity -> locationEntity.setAddress(this));
		this.locationEntities = locationEntities;
	}
	
	public void addLocationEntity(LocationEntity locationEntity) {
		this.locationEntities.add(locationEntity);
		locationEntity.setAddress(this);
	}

	public void setTrainingteams(List<TrainingteamEntity> trainingteams) {
		trainingteams.forEach(trainingteam -> trainingteam.setAddress(this));
		this.trainingteams = trainingteams;
	}
	
}
