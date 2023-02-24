package org.sam.converter_demo;

import org.sam.converter_demo.controller.Coordinator;
import org.sam.converter_demo.model.Logic;
import org.sam.converter_demo.view.WindowMain;
import org.sam.converter_demo.view.WindowGrade;
import org.sam.converter_demo.view.WindowCoin;

public class Main {
	public static void main(String[] args) {
		
	   Coordinator myCoordinator = new Coordinator();
	   
	   Logic logic = new Logic();
		
	   WindowMain windowMain = new WindowMain();
		 windowMain.setVisible(true);
		  
	   WindowCoin windowCoin = new WindowCoin();
		 // windowCoin.setVisible(false);
		  
	   WindowGrade windowGrade = new WindowGrade();
		 //windowGrade.setVisible(false);
		
	   windowMain.setCoordinator(myCoordinator);
	   windowCoin.setCoordinator(myCoordinator);
	   windowGrade.setCoordinator(myCoordinator);
	   logic.setCoordinator(myCoordinator);
	   
	   myCoordinator.setWindowOne(windowMain);
	   myCoordinator.setWindowTwo(windowCoin);
	   myCoordinator.setWindowThree(windowGrade);
	   myCoordinator.setLogic(logic);
		
	

	   /*
	  
	   double valor = 13;
	   Country pais = Country.PE;
	   double equivalencia = pais.getEquivalence();
	   
	   double coinDolar = logic.convertCoinDolar(valor, equivalencia);
	   double dolarCoin = logic.convertDolarCoin(valor, equivalencia);
	   double oneDolarCoin = logic.converOneDolarCoin(valor, equivalencia);
	   
	   System.out.println( String.valueOf(valor)+ " " + pais.getNameCoin() + " de " + pais.getCountry() + " -> Dólar => $ " + coinDolar);
	   System.out.println(  String.valueOf(valor)+ " " + "Dólar -> " + pais.getNameCoin() + " " + pais.getCountry() + " => $ " + dolarCoin);
	   System.out.println("1 Dólar -> " + pais.getNameCoin() + " de " + pais.getCountry() + " => " + oneDolarCoin);
		 
	   logic.getListCountries().forEach((k,v) -> System.out.println(k + " " + v));*/
	   
	   //myCoordinator.consultarPaises().forEach(System.out::println);
	}
}
