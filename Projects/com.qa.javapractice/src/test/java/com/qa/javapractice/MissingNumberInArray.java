package com.qa.javapractice;

public class MissingNumberInArray {

	public static void main(String[] args) {
		int a[] = {1,2,3,5,6,7,8};
		int sum=0;
		for(int i=0;i<a.length;i++)
		{
			sum=sum+a[i];
			
		}
		System.out.println("The sum of array is" +sum);
		
		int sum1=0;
		for(int j=1;j<=8;j++)
		{
			sum1=sum1+j;
			
		}
		System.out.println(sum1);

		System.out.println(sum1-sum);
	}

}
