package com.m_landalex.ufc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ufc_intern_employee")
public class UfcInternEmployeeEntity extends AbstractEntity {

	private String position;
	private String firstName;
	private String lastName;
	private int age;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private AddressEntity address;

	@ManyToOne
	@JoinColumn(name = "ufc_id", referencedColumnName = "id")
	private UfcEntity ufcEntity;
	
}
