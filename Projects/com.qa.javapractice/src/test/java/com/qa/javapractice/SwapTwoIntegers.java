package com.qa.javapractice;

public class SwapTwoIntegers {

	public static void main(String[] args) {

		int x=5;
		int y=10;
		
		int temp;
		temp=x;
		x=y;
		y=temp;
		
		System.out.println(x);
		System.out.println(y);
		
		// 2mnd approach
		
		x=x+y;
		y=x-y;
		x=x-y;
		System.out.println(x);
		System.out.println(y);
		
		//3rd approach
		
		x=x*y;
		y=x/y;
		x=x/y;
		System.out.println(x);
		System.out.println(y);

		
		
		
	}

}
