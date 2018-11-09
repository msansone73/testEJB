package br.msansone.testEJB.core;

import javax.ejb.Local;
import br.msansone.testEJB.Model.Resultado;

@Local
public interface IMath {
	
	public Resultado calculaJuros(Double valor, Double juros, Integer anos);

}
