package br.msansone.testEJB.core;

import br.msansone.testEJB.Model.Resultado;

public class MathFin {

	public static Resultado calculaJuros(Double valor, Double juros, Integer anos) {

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
