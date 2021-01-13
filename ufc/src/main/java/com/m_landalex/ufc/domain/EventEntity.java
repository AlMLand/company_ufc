package com.m_landalex.ufc.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
	@Enumerated(EnumType.STRING)
	private Announcer announcer;
	private LocalDate eventData;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "event_location_id", referencedColumnName = "id")
	private LocationEntity eventLocation;
	@OneToOne(cascade = CascadeType.ALL)
	private FightCardEntity fightCard;
	
	@ManyToOne
	@JoinColumn(name = "ufc_id", referencedColumnName = "id")
	private UfcEntity ufcEntity;
}
