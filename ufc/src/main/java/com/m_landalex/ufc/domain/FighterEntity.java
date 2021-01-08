package com.m_landalex.ufc.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.m_landalex.ufc.data.WeightClass;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fighter")
public class FighterEntity extends AbstractEntity {

	private WeightClass weightClass;
	private String firstName;
	private String lastName;
	private AddressEntity address;
	private int wins;
	private int loses;
	private int undecided;
	
}
