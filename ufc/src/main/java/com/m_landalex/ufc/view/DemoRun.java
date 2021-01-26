package com.m_landalex.ufc.view;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import com.m_landalex.ufc.data.Ufc;
import com.m_landalex.ufc.dbconnectionXA.AtomikosJTAConnectionMySQLDb_1XA;
import com.m_landalex.ufc.dbconnectionXA.AtomikosJTAConnectionMySQLDb_2XA;
import com.m_landalex.ufc.dbconnectionXA.TransactionManagerXA;
import com.m_landalex.ufc.exception.AsyncXAResourcesException;
import com.m_landalex.ufc.serviceXA.UfcServiceXA;

public class DemoRun {

	public static void main(String[] args) throws AsyncXAResourcesException {

		GenericApplicationContext context = new AnnotationConfigApplicationContext(TransactionManagerXA.class, 
				AtomikosJTAConnectionMySQLDb_2XA.class, AtomikosJTAConnectionMySQLDb_1XA.class);

		UfcServiceXA service = context.getBean(UfcServiceXA.class);
		show(service.fetchAll());

		context.close();

	}

	private static void show(List<Ufc> list) {
		list.forEach(System.out::println);
	}

}
