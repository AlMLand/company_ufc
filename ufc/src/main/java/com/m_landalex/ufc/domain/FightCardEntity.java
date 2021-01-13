package com.m_landalex.ufc.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "fight_card")
public class FightCardEntity extends AbstractEntity {

	@OneToOne(cascade = CascadeType.ALL)
	private MainCardEntity mainCard;
	@OneToOne(cascade = CascadeType.ALL)
	private PreliminaryCardEntity preliminaryCard;
	
	@OneToOne(mappedBy = "fightCard")
	@JoinColumn(name = "event", referencedColumnName = "id")
	private EventEntity eventEntity;
	
}
