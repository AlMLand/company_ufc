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
@Table(name = "announcer")
public class AnnouncerEntity extends AbstractEntity {

	private String ANNOUNCER_BRUCE_BUFFER;
	private String ANNOUNCER_JOSEPH_ANTHONY_MARTINEZ;
	
}
