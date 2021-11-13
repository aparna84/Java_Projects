package com.qa.utils;

import com.qa.javapractice.CalculatorClass;

public class callingCalculator {

	public static void main(String[] args) {
		CalculatorClass cc= new CalculatorClass();
		System.out.println("addition of 2 numbers is-->"+cc.add(5, 5));
		System.out.println("Substraction of 2 numbers is-->"+cc.sub(10,5));
		System.out.println("multiplication of 2 numbers is-->"+cc.mul(2, 2));
		System.out.println("Division is-->"+cc.div(20, 2));

	}

}
