package com.m_landalex.ufc.data;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Ufc extends AbstractObject {

	@Singular
	private List<Event> ufcEvents;
	private Address ufcAddress;
	@Singular
	private List<UfcInterEmployee> ufcInterEmployees;

}
