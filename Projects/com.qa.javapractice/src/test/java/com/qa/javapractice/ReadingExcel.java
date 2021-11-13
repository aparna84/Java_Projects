package com.qa.javapractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream fis= new FileInputStream("F:\\Aparna_Java\\TestData\\ReadingData.xlsx");
		XSSFWorkbook book= new XSSFWorkbook(fis);
		
		XSSFSheet sheet = book.getSheet("credentials");
		XSSFRow row= sheet.getRow(0);
		
		int col_num=-1;
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().equals("NoOfAttempts"));
			col_num=i;
			break;
		}
		
		row=sheet.getRow(1);
		
		XSSFCell cell=row.getCell(col_num); //i =1
		
		String cellValue=cell.getStringCellValue();
		System.out.println(cellValue);
		
		
	}

}
