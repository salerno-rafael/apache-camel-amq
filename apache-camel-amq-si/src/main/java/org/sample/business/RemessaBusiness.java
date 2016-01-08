package org.sample.business;

import java.util.List;

import org.apache.log4j.Logger;
import org.sample.adapter.RemessaEntityAdapter;
import org.sample.dao.RemessaDao;
import org.sample.model.Remessa;

public class RemessaBusiness {

	private static Logger logger = Logger.getLogger(RemessaBusiness.class);

	private RemessaDao remessaDao;

	private RemessaEntityAdapter remessaEntityAdapter;
	
	public RemessaBusiness(RemessaDao remessaDao, RemessaEntityAdapter remessaEntityAdapter) {
		this.remessaDao = remessaDao;
		this.remessaEntityAdapter = remessaEntityAdapter;
	}

	public List<Remessa> list() {
		logger.info("list remessa");
		return remessaEntityAdapter.entityToRemessa(remessaDao.list());
	}

	public Remessa find(Remessa remessa) {
		logger.info("find remessa");
		return remessaEntityAdapter.entityToRemessa(remessaDao.find(remessaEntityAdapter.remessaToEntity(remessa)));

	}
}
