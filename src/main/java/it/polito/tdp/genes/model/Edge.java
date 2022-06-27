package it.polito.tdp.genes.model;

public class Edge {

	String l1;
	String l2;
	int peso;
	public Edge(String l1, String l2, int peso) {
		super();
		this.l1 = l1;
		this.l2 = l2;
		this.peso=peso;
	}
	
	
	
	public int getPeso() {
		return peso;
	}



	public void setPeso(int peso) {
		this.peso = peso;
	}



	public String getL1() {
		return l1;
	}
	public void setL1(String l1) {
		this.l1 = l1;
	}
	public String getL2() {
		return l2;
	}
	public void setL2(String l2) {
		this.l2 = l2;
	}
	
	
}
