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
public class UfcInterEmployee extends AbstractObject {

	private String position;
	private String firstName;
	private String lastName;
	private int age;
	private Address address;

	@Override
	public String toString() {
		return "UfcInterEmployee " + super.toString() + " [position=" + position + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", address=" + address + "]";
	}
	
}
