package br.com.ilegra.contract;

public class RemessaOutput {

	private int id;
	private String nrRemessa;
	private double valor;

	public RemessaOutput() {
	}

	public RemessaOutput(int id, String nrRemessa, double valor) {
		this.id = id;
		this.nrRemessa = nrRemessa;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNrRemessa() {
		return nrRemessa;
	}

	public void setNrRemessa(String nrRemessa) {
		this.nrRemessa = nrRemessa;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "RemessaOutput [id=" + id + ", nrRemessa=" + nrRemessa + ", valor=" + valor + "]";
	}

}
