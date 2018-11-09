package br.msansone.testEJB.core;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

import br.msansone.testEJB.Model.Resultado;

@Stateless
@Default
public class MathFin implements IMath {

	public MathFin() {
		super();
	}

	public Resultado calculaJuros(Double valor, Double juros, Integer anos) {

		juros = juros / 100;

		Double valFuturo;
		Double valJurosTotais;
		Double valJurosAno;

		valFuturo = valor * (1 + juros * anos);
		valJurosTotais = valor * juros * anos;
		valJurosAno = valor * juros;

		Resultado resultado = new Resultado();
		resultado.setValFuturo(valFuturo);
		resultado.setValJuros(valJurosTotais);
		resultado.setValJurosAnos(valJurosAno);
		resultado.setReturnValue(0);
		resultado.setReturnDescription("");
		resultado.setTrack("");

		return resultado;
	}

}
