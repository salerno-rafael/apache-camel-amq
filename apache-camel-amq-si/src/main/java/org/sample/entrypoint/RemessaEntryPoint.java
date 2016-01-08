package org.sample.entrypoint;

import org.sample.adapter.RemessaToOutputAdapter;
import org.sample.business.RemessaBusiness;

import br.com.ilegra.contract.LoaderInputMessage;
import br.com.ilegra.contract.LoaderOutupMessage;
import br.com.ilegra.contract.RemessaService;

public class RemessaEntryPoint implements RemessaService {

	private RemessaBusiness remessaBusiness;

	private RemessaToOutputAdapter remessaToOutputAdapter;
	
	public RemessaEntryPoint(RemessaBusiness remessaBusiness, RemessaToOutputAdapter remessaToOutputAdapter) {
		this.remessaBusiness = remessaBusiness;
		this.remessaToOutputAdapter = remessaToOutputAdapter;
	}

	public LoaderOutupMessage list(LoaderInputMessage input) {
		return remessaToOutputAdapter.inputToOutput(remessaBusiness.list());
	}
}
