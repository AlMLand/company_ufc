package com.m_landalex.ufc.domain;

import java.util.List;

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
@Table(name = "main_card")
public class MainCardEntity extends AbstractEntity {

	private List<FightEntity> fightList;
	
}
