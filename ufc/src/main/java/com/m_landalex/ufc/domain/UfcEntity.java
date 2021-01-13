package com.m_landalex.ufc.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
@Table(name = "ufc")
public class UfcEntity extends AbstractEntity {

	@OneToMany(mappedBy = "ufcEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<EventEntity> ufcEvents;
	@Setter
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ufc_head_address_id", referencedColumnName = "id")
	private AddressEntity ufcAddress;
	@OneToMany(mappedBy = "ufcEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UfcInternEmployeeEntity> ufcInterEmployees;
	
	public void setUfcEvents(List<EventEntity> ufcEvents) {
		ufcEvents.forEach(ufcEvent -> ufcEvent.setUfcEntity(this));
		this.ufcEvents = ufcEvents;
	}
	
	public void addUfcEventEntity(EventEntity eventEntity) {
		this.ufcEvents.add(eventEntity);
		eventEntity.setUfcEntity(this);
	}
	
	public void setUfcInterEmployees(List<UfcInternEmployeeEntity> ufcInterEmployees) {
		ufcInterEmployees.forEach(ufcInterEmployee -> ufcInterEmployee.setUfcEntity(this));
		this.ufcInterEmployees = ufcInterEmployees;
	}
	
	public void addUfcInterEmployeeEntity(UfcInternEmployeeEntity ufcInternEmployeeEntity) {
		this.ufcInterEmployees.add(ufcInternEmployeeEntity);
		ufcInternEmployeeEntity.setUfcEntity(this);
	}

}
