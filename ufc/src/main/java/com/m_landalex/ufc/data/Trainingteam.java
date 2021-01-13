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
public class Trainingteam extends AbstractObject {

	private String teamName;
	private Address address;

	@Override
	public String toString() {
		return "Trainingteam " + super.toString() + " [teamName=" + teamName + ", address=" + address + "]";
	}
	
}
