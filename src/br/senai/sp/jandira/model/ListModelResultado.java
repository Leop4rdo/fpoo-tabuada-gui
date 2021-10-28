package br.senai.sp.jandira.model;

import javax.swing.DefaultListModel;

public class ListModelResultado extends DefaultListModel<String>{
	public void addArrayOfElements(String[] arr) {
		for (int i = 0; i < arr.length; i++) {
			this.addElement(arr[i]);
		}
	}
}
