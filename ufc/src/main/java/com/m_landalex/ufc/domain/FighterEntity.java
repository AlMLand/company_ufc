package com.m_landalex.ufc.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@Enumerated(EnumType.STRING)
	private WeightClass weightClass;
	private int ufcRanked;
	private String firstName;
	private String lastName;
	private int age;
	@ManyToOne
	@JoinColumn(name = "training_team_id", referencedColumnName = "id")
	private TrainingteamEntity trainingteam;
	private int wins;
	private int loses;
	private int undecided;
	
	@ManyToOne
	@JoinColumn(name = "fight_id", referencedColumnName = "id")
	private FightEntity fightEntity;
	
}
