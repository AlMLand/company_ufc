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
public class PreliminaryCard extends AbstractObject {

	@Singular
	private List<Fight> fights;

	@Override
	public String toString() {
		return "PreliminaryCard " + super.toString() + " [fights=" + fights + "]";
	}

}
