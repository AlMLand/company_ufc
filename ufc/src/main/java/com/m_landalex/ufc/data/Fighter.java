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
public class Fighter extends AbstractObject {

	private WeightClass weightClass;
	private String firstName;
	private String lastName;
	private Address address;
	private int wins;
	private int loses;
	private int undecided;
	
	@Override
	public String toString() {
		return "Fighter [" + super.toString() + ", weightClass=" + weightClass + ", firstName=" + firstName + ", lastName=" + lastName + ", wins="
				+ wins + ", loses=" + loses + ", undecided=" + undecided + "]";
	}
	
}
