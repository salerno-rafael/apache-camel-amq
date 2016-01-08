package org.sample.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.sample.entity.RemessaEntity;

public class RemessaDao {

	private static Logger logger = Logger.getLogger(RemessaDao.class);
	 
	public List<RemessaEntity> list() {
		logger.info("list remesssas");
		return buildRemessas();
	}
	
	private List<RemessaEntity> buildRemessas() {
		List<RemessaEntity> remessas = new ArrayList<RemessaEntity>();
		remessas.add(new RemessaEntity(1, "12345", 10));
		remessas.add(new RemessaEntity(2, "67890", 6));
		remessas.add(new RemessaEntity(3, "54321", 12));
		return remessas;
	}

	public void update(RemessaEntity remessa) {
		logger.info("update remessa");
	}

	public void insert(RemessaEntity remessa) {
		logger.info("insert remessa");
	}
	
	public void delete(RemessaEntity remessa) {
		logger.info("delete remessa");
	}

	public RemessaEntity find(RemessaEntity remessa) {
		logger.info("find remessa");
		return new RemessaEntity();
	}
}
