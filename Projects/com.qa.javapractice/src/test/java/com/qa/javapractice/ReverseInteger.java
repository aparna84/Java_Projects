package com.qa.javapractice;

public class ReverseInteger {

	public static void main(String[] args) {
		int num=12345;
		int  Rev=0;
		
		while(num!=0)
		{
			Rev=Rev*10+num%10;
			num=num/10;
		}
		System.out.println(Rev);
	}

}
