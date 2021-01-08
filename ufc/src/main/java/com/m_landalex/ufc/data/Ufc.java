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
public class Ufc extends AbstractObject {

	private Event ufcEvent;
	private Address address;
	private String generalManager;

	@Override
	public String toString() {
		return "Ufc [" + super.toString() + ", ufcEvent=" + ufcEvent + "]";
	}
	
}
