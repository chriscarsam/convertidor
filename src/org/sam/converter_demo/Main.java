package org.sam.converter_demo;

import org.sam.converter_demo.controller.Coordinator;
import org.sam.converter_demo.model.ILogic;
import org.sam.converter_demo.model.Logic;
import org.sam.converter_demo.view.WindowMain;
import org.sam.converter_demo.view.WindowGrade;
import org.sam.converter_demo.view.WindowCoin;

public class Main {
	
	public static void main(String[] args) {
		
	   Coordinator myCoordinator = new Coordinator();
	   
	   ILogic logic = new Logic();
		
	   WindowMain windowMain = new WindowMain();		 		  
	   WindowCoin windowCoin = new WindowCoin();		  
	   WindowGrade windowGrade = new WindowGrade();	  
	   
	   windowMain.setCoordinator(myCoordinator);
	   windowCoin.setCoordinator(myCoordinator);
	   windowGrade.setCoordinator(myCoordinator);
	   ((Logic) logic).setCoordinator(myCoordinator);
	   
	   myCoordinator.setWindowOne(windowMain);
	   myCoordinator.setWindowTwo(windowCoin);
	   myCoordinator.setWindowThree(windowGrade);
	   myCoordinator.setLogic((Logic) logic);

	   myCoordinator.showWindowMain();
	}
	
}
