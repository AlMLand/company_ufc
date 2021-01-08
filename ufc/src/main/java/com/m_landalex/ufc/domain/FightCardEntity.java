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
@Table(name = "fight_card")
public class FightCardEntity extends AbstractEntity {

	private MainCardEntity mainCard;
	private PreliminaryCardEntity preliminaryCard;
	
}
