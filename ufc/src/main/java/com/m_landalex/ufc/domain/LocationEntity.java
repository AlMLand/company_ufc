package com.m_landalex.ufc.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.m_landalex.ufc.data.Country;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "location")
public class LocationEntity extends AbstractEntity {

	private Country country;
	private String hallName;
	private AddressEntity address;
	
}
