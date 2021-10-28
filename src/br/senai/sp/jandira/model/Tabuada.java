package br.senai.sp.jandira.model;

public class Tabuada {
	private String[] tabuada;
	
	public void calcular(String multiplicandoString, String maxMultiplicadorString) {
		int multiplicando = Integer.parseInt(multiplicandoString);
		int maxMultiplicador = Integer.parseInt(maxMultiplicadorString);
		
		tabuada = new String[maxMultiplicador + 1];
		
		for (int i = 0; i< tabuada.length; i++) {
			int resultado = multiplicando * i;
			
			tabuada[i] = multiplicando + " X " + i + " = " + resultado;
		}
	}
	
	public String[] getTabuada() {
		return tabuada;
	}
}
