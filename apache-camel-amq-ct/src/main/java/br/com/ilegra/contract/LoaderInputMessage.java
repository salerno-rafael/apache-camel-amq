package br.com.ilegra.contract;

public class LoaderInputMessage {

	public LoaderInputMessage(String message) {
		this.message = message;
	}

	public LoaderInputMessage() {
	}

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
