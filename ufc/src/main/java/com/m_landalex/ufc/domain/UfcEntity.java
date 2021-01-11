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
	/*
	 * only for @OneToOne
	 * Здесь нужно обратить внимание на использование атрибута mappedBy и аннотации @JoinColumn. 
	 * Код будет работать независимо от того в какой из сущностей будет указан @OneToOne(mappedBy = “”), 
	 * а в какой @JoinColumn(name = “”, referencedColumnName = “”), 
	 * но есть рекомендация использовать @JoinColumn в той сущности, 
	 * которая имеет физическую информацию(т.е. этот атрибут есть в DTO), а не ссылку foreign key. 
	 */
	@Setter
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "ufcEntity")
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
