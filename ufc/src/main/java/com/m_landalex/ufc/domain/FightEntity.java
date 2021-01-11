package com.m_landalex.ufc.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.m_landalex.ufc.data.Referee;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "fight")
public class FightEntity extends AbstractEntity {

	@Setter
	private int fightNumberInCard;
	@Setter
	@Enumerated(EnumType.STRING)
	private Referee referee;
	@OneToMany(mappedBy = "fightEntity", cascade = CascadeType.ALL)
	@JoinColumn(name = "fighters")
	private List<FighterEntity> fighters;
	
	@Setter
	@ManyToOne
	@JoinColumn(name = "main_card_id", referencedColumnName = "id")
	private MainCardEntity mainCardEntity;
	
	@Setter
	@ManyToOne
	@JoinColumn(name = "preliminary_card_id", referencedColumnName = "id")
	private PreliminaryCardEntity preliminaryCardEntity;

	public void setFighters(List<FighterEntity> fighters) {
		fighters.forEach(fighter -> fighter.setFightEntity(this));
		this.fighters = fighters;
	}
	
	public void addFighterEntity(FighterEntity fighterEntity) {
		this.fighters.add(fighterEntity);
		fighterEntity.setFightEntity(this);
	}
	
}
