package br.dev.aline.temperatura.model;

public class Temperatura {

	//Declarando Atributos
	private double celsius;


	//Métodos Setters e Getters do atributo celsius
	public double getCelsius( ) {
	return celsius;
	}

	public void setCelsius(double celsius) {
	this.celsius = celsius;
	}

	//Métodos para conversão em kelvin
	public double converterParaKelvin( ) {
	//Fórmula para conversão de Celsius para Kelvin
	double kelvin = celsius + 273.15;
	return kelvin;
	}
	//Métodos para conversão em Fahreinheit
	public double converterParaFahreinheit( ) {
	//Fórmula para conversão de Celsius para Fahreinheit
	double fahreinheit = (celsius * 1.8) + 32;
	return fahreinheit;
	}
	}
