package com.m_landalex.ufc.serviceXA;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.m_landalex.ufc.data.Ufc;
import com.m_landalex.ufc.domain.UfcEntity;
import com.m_landalex.ufc.exception.AsyncXAResourcesException;
import com.m_landalex.ufc.mapper.UfcMapper;

@Transactional
@Repository
@Service
public class UfcServiceXA {

	@Autowired
	private UfcMapper ufcMapper;
	@PersistenceContext(unitName = "db_1EntityManager")
	private EntityManager db_1EntityManager;
	@PersistenceContext(unitName = "db_2EntityManager")
	private EntityManager db_2EntityManager;
	
	@Transactional(readOnly = true, rollbackFor = AsyncXAResourcesException.class)
	public List<Ufc> fetchAll() throws AsyncXAResourcesException {
		List<Ufc> returnedUfcList_1 = ufcMapper
				.toDTOList(db_1EntityManager.createQuery("SELECT u FROM UfcEntity u", UfcEntity.class).getResultList());
		List<Ufc> returnedUfcList_2 = ufcMapper
				.toDTOList(db_2EntityManager.createQuery("SELECT u FROM UfcEntity u", UfcEntity.class).getResultList());
		List<Ufc> listResult = new ArrayList<Ufc>();
		if (returnedUfcList_1.size() != returnedUfcList_2.size()) {
			throw new AsyncXAResourcesException("XA resources do not contain the same expected data");
		} else {
			listResult.addAll(returnedUfcList_1);
			listResult.addAll(returnedUfcList_2);
		}
		return listResult;
	}
	
	public Ufc save(Ufc ufc) {
		if (ufc.getId() == null) {
			db_1EntityManager.persist(ufcMapper.toEntity(ufc));
			db_2EntityManager.persist(ufcMapper.toEntity(ufc));
		} else {
			db_1EntityManager.merge(ufcMapper.toEntity(ufc));
			db_2EntityManager.merge(ufcMapper.toEntity(ufc));
		}
		return ufc;
	}
	
}
