package com.m_landalex.ufc.view;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.m_landalex.ufc.data.Ufc;
import com.m_landalex.ufc.dbconnection.H2Connection;
import com.m_landalex.ufc.service.UfcService;

public class DemoRun {

	public static void main(String[] args) {
		
		GenericApplicationContext context = new AnnotationConfigApplicationContext(H2Connection.class);
		
		UfcService service = context.getBean(UfcService.class);
		show(service.fetchAll());
		
		context.close();

	}

	private static void show(List<Ufc> list) {
		list.forEach(System.out::println);
	}

}
