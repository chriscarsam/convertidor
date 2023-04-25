package org.sam.converter_demo.model;

import java.util.HashMap;

public interface ILogic {
	
	double convertCoinDolar(double valor, double equivalence);
	double convertDolarCoin(double valor, double equivalence);
	HashMap<Double, String> getListCountries();
	String converGrade(double valor, int opt);
	
}
