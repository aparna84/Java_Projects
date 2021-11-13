package com.qa.javapractice;

public class SwapSrings {

	public static void main(String[] args) {

		String a="Hello";
		String b="World";
		
		System.out.println("Before Swapping a and b values are");
		System.out.println(a);
		System.out.println(b);
		
		//Append a and b
		
		a=a+b;
		
		System.out.println(a);
		
		//Divide the string using substring method
		
		b=a.substring(0,a.length()-b.length());
		System.out.println("b values is"+b);
		
		a=a.substring(b.length());
		System.out.println("a values is"+a);
		
		System.out.println("After Swapping a and b values are");
		System.out.println(a);
		System.out.println(b);
		
	}

}
