package org.sample.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.sample.entity.RemessaEntity;
import org.sample.model.Remessa;

public class RemessaEntityAdapter {

	public Remessa entityToRemessa(RemessaEntity entity) {
		return new Remessa(entity.getId(), entity.getNrRemessa(), entity.getValue());
	}

	public List<Remessa> entityToRemessa(List<RemessaEntity> entities) {
		return entities.stream().map(e -> new Remessa(e.getId(), e.getNrRemessa(), e.getValue()))
				.collect(Collectors.toList());
	}
	
	public RemessaEntity remessaToEntity(Remessa remessa) {
		return new RemessaEntity(remessa.getId(), remessa.getNrRemessa(), remessa.getValue());
	}

	public List<RemessaEntity> remessaToEntity(List<Remessa> remessas) {
		return remessas.stream().map(r -> new RemessaEntity(r.getId(), r.getNrRemessa(), r.getValue()))
				.collect(Collectors.toList());
	}

}
