package com.m_landalex.ufc.data;

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
public class FightCard extends AbstractObject {

	private MainCard mainCard;
	private PreliminaryCard preliminaryCard;

	@Override
	public String toString() {
		return "FightCard " + super.toString() + " [mainCard=" + mainCard + ",\n preliminaryCard=" + preliminaryCard + "]";
	}
	
}
