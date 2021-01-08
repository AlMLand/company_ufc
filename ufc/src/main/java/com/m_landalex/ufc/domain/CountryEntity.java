package com.m_landalex.ufc.domain;

import javax.persistence.Entity;
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
@Table(name = "country")
public class CountryEntity extends AbstractEntity {

	private String COUNTRY_USA;
	private String COUNTRY_GERMANY;
	private String COUNTRY_RUSSIA; 
	private String COUNTRY_UAE;
	
}
