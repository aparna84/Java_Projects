package com.qa.javapractice;

public class LargestSmallestNumber {

	public static void main(String[] args) {
		int a[]= {20,10,15,5,-3,99};
		
		int smallestNumber = a[0];
		int largestNumber = a[0];
		
		for(int i=1;i<a.length;i++)
		{
			if(a[i]>a[0])
			{
				largestNumber=a[i];
			}
				else
				smallestNumber= a[i];
			
		}
		System.out.println("LargestNumber-->"+largestNumber);
		System.out.println("smallestNumber-->"+smallestNumber);
	}

}
