package org.sam.converter_demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;

import org.sam.converter_demo.model.Logic;
import org.sam.converter_demo.view.WindowMain;
import org.sam.converter_demo.view.WindowGrade;
import org.sam.converter_demo.view.WindowCoin;

public class Coordinator {
	
	private WindowMain windowMain;
	private WindowCoin windowCoin;
	private WindowGrade windowGrade;
	private Logic logic;

	public void setWindowOne(WindowMain windowOne) {
		this.windowMain = windowOne;		
	}

	public void setWindowTwo(WindowCoin windowTwo) {
		this.windowCoin = windowTwo;		
	}

	public void setWindowThree(WindowGrade windowThree) {
		this.windowGrade = windowThree;		
	}

	public void setLogic(Logic logic) {
		this.logic = logic;		
	}

	public void showWindow(int window) {
		switch(window) {
		case 0:	
			windowCoin.setVisible(true); 			
			windowGrade.setVisible(false);	
			windowCoin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			break;
		case 1: 
			windowGrade.setVisible(true);			
			windowCoin.setVisible(false);
			windowGrade.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			break;
		}
	}

	public  HashMap<Double, String> consultarPaises() {		
		return	logic.getListCountries();
	}
	
	public double convertirMonedaDolar(double valor, double equivalence) {
		return logic.convertCoinDolar(valor, equivalence);
	}
	
	public double convertirDolarMoneda(double valor, double equivalence) {
		return logic.convertDolarCoin(valor, equivalence);
	}

	public String convertirGrado(double valor, int opt) {
		return logic.converGrade(valor, opt);
	}
}
