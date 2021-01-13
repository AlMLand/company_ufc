package com.m_landalex.ufc.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractObject {

	private Long id;

	@Override
	public String toString() {
		return "id=" + id;
	}
	
}
