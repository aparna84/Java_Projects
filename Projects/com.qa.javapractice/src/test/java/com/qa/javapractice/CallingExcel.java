package com.qa.javapractice;

import java.io.IOException;

import com.qa.utils.ReadingExcelFromUtils;

public class CallingExcel {

	public static void main(String[] args) throws IOException {
		
		String cellValue;
		ReadingExcelFromUtils obj= new ReadingExcelFromUtils();
		obj.OpenExcelFile("F:\\\\Aparna_Java\\\\TestData\\\\ReadingData.xlsx");
		//cellValue=obj.ReadData("credentials", "DateCreated", 4);
		//System.out.println(cellValue);
		
		//obj.getColumnValues("credentials", "NoOfAttempts");
		obj.getExcelValues("credentials");
		
	}

}
