package com.m_landalex.ufc.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AsyncXAResourcesException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private String text;
	
	public AsyncXAResourcesException(String text) {
		this.text = text;
	}

}
