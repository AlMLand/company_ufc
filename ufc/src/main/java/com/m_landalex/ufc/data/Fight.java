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
public class Fight extends AbstractObject {

	private int fightNumberInCard;
	private Referee referee;
	private Fighter fighter1;
	private Fighter fighter2;

	@Override
	public String toString() {
		return "Fight [" + super.toString() + ", fightNumber=" + fightNumberInCard + ", referee=" + referee + ", fighter1=" + fighter1 + ", fighter2="
				+ fighter2 + "]";
	}
	
}
