package br.msansone.testEJB.Model;

import javax.ejb.Stateless;

@Stateless
public class Resultado extends Retorno {

	private double valFuturo;
	private double valJuros;
	private double valJurosAnos;

	public double getValFuturo() {
		return valFuturo;
	}

	public void setValFuturo(double valFuturo) {
		this.valFuturo = valFuturo;
	}

	public double getValJuros() {
		return valJuros;
	}

	public void setValJuros(double valJuros) {
		this.valJuros = valJuros;
	}

	public double getValJurosAnos() {
		return valJurosAnos;
	}

	public void setValJurosAnos(double valJurosAnos) {
		this.valJurosAnos = valJurosAnos;
	}

}
