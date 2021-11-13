package com.qa.javapractice;

public class ReverseString {

	public static void main(String[] args) {
		String s= "Selenium";
		String s2="Java Program";
		String rev="";
		int len=s.length();
		for(int i=len-1; i>=0;i--)
		{
			rev=rev+s.charAt(i);
		}
		System.out.println(rev);
		
		StringBuffer bf= new StringBuffer(s2);
		System.out.println(bf.reverse());

	}

	
}

