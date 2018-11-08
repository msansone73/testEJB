package br.msansone.testEJB.Model;

import lombok.Data;

@Data
public class Retorno {
	
	private Integer returnValue;
	private String returnDescription;
	private String track;

}
