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
@Table(name = "referee")
public class RefereeEntity extends AbstractEntity {

	private String REFEREE_DAN_MIRAGLIOTTA; 
	private String REFEREE_MIKE_BELTRAN; 
	private String REFEREE_MARC_GODDARD;
	private String REFEREE_STEVE_MAZZAGATTI; 
	private String REFEREE_MARIO_YAMASAKI;
	
}
