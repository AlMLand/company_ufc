package com.m_landalex.ufc.data;

import java.util.List;

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
public class MainCard extends AbstractObject {

	private List<Fight> fightList;

	@Override
	public String toString() {
		return "MainCard [fightList=" + fightList.size() + " fights]";
	}
	
}
