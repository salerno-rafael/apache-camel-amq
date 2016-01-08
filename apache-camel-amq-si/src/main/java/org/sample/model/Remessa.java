package org.sample.model;

public class Remessa {

	private int id;
	private String nrRemessa;
	private double value;

	public Remessa(){}
	
	public Remessa(int id, String nrRemessa, double value) {
		this.id = id;
		this.nrRemessa = nrRemessa;
		this.value = value;
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

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
}
