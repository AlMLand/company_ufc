package com.m_landalex.ufc.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "preliminary_card")
public class PreliminaryCardEntity extends AbstractEntity {

	@OneToMany(mappedBy = "preliminaryCardEntity", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<FightEntity> fights;

	@Setter
	@OneToOne
	@JoinColumn(name = "fight_card_id", referencedColumnName = "id")
	private FightCardEntity fightCardEntity;

	public void setFights(List<FightEntity> fights) {
		fights.forEach(fight -> fight.setPreliminaryCardEntity(this));
		this.fights = fights;
	}
	
	public void addFightEntity(FightEntity fightEntity) {
		this.fights.add(fightEntity);
		fightEntity.setPreliminaryCardEntity(this);
	}
	
}
