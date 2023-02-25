package org.sam.converter_demo.model;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

import org.sam.converter_demo.controller.Coordinator;

public class Logic {
	
	@SuppressWarnings("unused")
	private Coordinator myCoordinator;
	private double equivalence;
	private NumberFormat formatter = new DecimalFormat("#0.0000");

	public double convertCoinDolar(double valor, double equivalence) {
		return valor * equivalence;
	}

	public double convertDolarCoin(double valor, double equivalence) {
		return valor / equivalence;
	}

	public HashMap<Double, String> getListCountries(){
		HashMap<Double, String> listaPaises= new HashMap<>();
				
		for(Country c: Country.values()) {
			listaPaises.put(c.getEquivalence(), c.getNameCoin() + " de " + c.getCountry());
		}
		
		return listaPaises;
	}
	
	public void setCoordinator(Coordinator myCoordinator) {
		this.myCoordinator = myCoordinator;
	}
	
	public String converGrade(double valor, int opt) {
	  String sigla = "";
		
		switch(opt){
			case 0 : 
				// "Celsius To Fahrenheit "
				sigla = "°F ";
				this.equivalence = (valor * 1.8) + 32;				
				break;
				
			case 1 : 
				// "Celsius To Kelvin "
				sigla = " K ";
				this.equivalence = valor + 273.15;				
				break;
				
			case 2 : 
				// "Celsius To Rankine "
				sigla = "°R ";
				this.equivalence = (valor + 273.15) / 1.8;				
				break;
				
			case 3 : 
				// "Fahrenheit To Celsius "
				sigla = "°C ";
				this.equivalence = (valor - 32) / 1.8;
				break;
				
			case 4 : 
				// "Fahrenheit To Kelvin "
				sigla = " K ";
				this.equivalence = (valor - 32) / 1.8 + 273.15;				
				break;
				
			case 5 : 
				// "Fahrenheit To Rankine "
				sigla = "°R ";
				this.equivalence = valor + 459.67;		
				break;
				
			case 6 : 
				// "Kelvin To Celsius "
				sigla = "°C ";
				this.equivalence = valor - 273.15;			
				break;
			
			case 7 : 
				// "Kelvin To Fahrenheit "
				sigla = "°F ";
				this.equivalence = valor * 1.8 - 459.67;			
				break;
				
			case 8 : 
				// "Kelvin To Rankine "
				sigla = "°R ";
				this.equivalence = valor * 1.8;		
				break;
				
			case 9 : 
				// "Rankine To Celsius "
				sigla = "°C ";
				this.equivalence = (valor - 491.67) / 1.8;		
				break;
				
			case 10 : 
				// "Rankine To Fahrenheit "
				sigla = "°F ";
				this.equivalence = valor - 459.67;
				break;
				
			case 11 : 
				// "Rankine To Kelvin "
				sigla = " K ";
				this.equivalence = valor / 1.8;				
				break;				
		}
		
		return  sigla + " = " + formatter.format(this.equivalence);
		
	}


}
