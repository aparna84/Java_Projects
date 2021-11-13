package com.java.examples;

public class CustomCalculator {

	public int addition(int a,int b) {
		return a + b;
	}
	
	public double substraction(int a, int b) {
		if(a > b) {
			return a - b;
		}else {
			return 0;
		}
	}
	
	public double multiplication(int a, int b) {
		return a * b;
	}
}
