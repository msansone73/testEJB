package br.msansone.testEJB.Model;

import javax.ejb.Stateless;

import lombok.Data;

@Data
@Stateless
public class Retorno {
	
	private Integer returnValue;
	private String returnDescription;
	private String track;

}
