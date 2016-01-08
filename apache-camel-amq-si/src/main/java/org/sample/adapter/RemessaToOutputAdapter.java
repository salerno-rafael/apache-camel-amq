package org.sample.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.sample.model.Remessa;

import br.com.ilegra.contract.LoaderOutupMessage;
import br.com.ilegra.contract.RemessaOutput;

public class RemessaToOutputAdapter {

	public LoaderOutupMessage inputToOutput(List<Remessa> remessas) {
		return new LoaderOutupMessage("remessas",remessas.stream()
				.map(r -> new RemessaOutput(r.getId(), r.getNrRemessa(), r.getValue())).collect(Collectors.toList()));
	}

}
