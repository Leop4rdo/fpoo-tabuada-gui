package br.senai.sp.jandira.model;

public class CalculadoraTabuada {
	private String[] tabuada;
	
	public void calcular(int multiplicando, int maxMultiplicador) {
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
