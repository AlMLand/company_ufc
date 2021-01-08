package com.m_landalex.ufc.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.m_landalex.ufc.data.Announcer;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "event")
public class EventEntity extends AbstractEntity {

	private String eventName;
	private int eventNumber;
	private Announcer announcer;
	private LocalDate eventData;
	private LocationEntity eventLocation;
	private FightCardEntity fightCard;
	
}
