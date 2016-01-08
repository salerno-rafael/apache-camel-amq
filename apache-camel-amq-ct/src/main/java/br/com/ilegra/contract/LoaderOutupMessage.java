package br.com.ilegra.contract;

import java.util.List;

public class LoaderOutupMessage {

	private String message;

	private List<RemessaOutput> remessas;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<RemessaOutput> getRemessas() {
		return remessas;
	}

	public void setRemessas(List<RemessaOutput> remessas) {
		this.remessas = remessas;
	}

	public LoaderOutupMessage(String message, List<RemessaOutput> remessas) {
		this.message = message;
		this.remessas = remessas;
	}
	
	@Override
	public String toString() {
		return "LoaderOutupMessage [message=" + message + ", remessas=" + remessas + "]";
	}
	
}
