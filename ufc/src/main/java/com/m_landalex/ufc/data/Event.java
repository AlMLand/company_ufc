package com.m_landalex.ufc.data;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Event extends AbstractObject {

	private String eventName;
	private int eventNumber;
	private Announcer announcer;
	private LocalDate eventData;
	private Location eventLocation;
	private FightCard fightCard;

}
