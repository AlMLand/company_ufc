package com.m_landalex.ufc.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.m_landalex.ufc.data.Referee;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fight")
public class FightEntity extends AbstractEntity {

	private int fightNumberInCard;
	private Referee referee;
	private FighterEntity fighter1;
	private FighterEntity fighter2;
	
}
