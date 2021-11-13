package com.qa.javapractice;

public class ReplaceSplChar {

	public static void main(String[] args) {
		String s="@#$%?234ADV#$%#$^23423423%^&";
		
		s=s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(s);
		
	}

}
