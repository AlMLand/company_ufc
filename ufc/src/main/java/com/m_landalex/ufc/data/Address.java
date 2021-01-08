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
public class Address extends AbstractObject {

	private String city;
	private String street;
	private String houseNumber;
	private String postCode;
	
	@Override
	public String toString() {
		return "Address [" + super.toString() + ", city=" + city + ", street=" + street + ", houseNumber=" + houseNumber + ", postCode="
				+ postCode + "]";
	}
	
}
