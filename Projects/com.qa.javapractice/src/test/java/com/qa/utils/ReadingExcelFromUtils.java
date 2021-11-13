package com.qa.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcelFromUtils {
	
	XSSFWorkbook book;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	

	public void OpenExcelFile(String FilePath) throws IOException
	{
		FileInputStream fis= new FileInputStream(FilePath);
		book= new XSSFWorkbook(fis);
		fis.close();
		
	}
	
	public String ReadData(String SheetName, String ColName, int RowNum) {
		try {
			
		
		sheet = book.getSheet(SheetName);
		row= sheet.getRow(0);
		
		int col_num=-1;
		
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(ColName)) {
			col_num=i;
			break;
			}
		}
		
		System.out.println(col_num);
		row=sheet.getRow(RowNum-1);
		cell=row.getCell(col_num);
		
		if(cell.getCellTypeEnum()== CellType.STRING) {
			
			return cell.getStringCellValue();
		}else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA)
			{
				String CellValue=String.valueOf(cell.getNumericCellValue());
				if(HSSFDateUtil.isCellDateFormatted(cell))
				{
					DateFormat dr= new SimpleDateFormat("dd/MM/yyyy");
					Date date=cell.getDateCellValue();
					CellValue=dr.format(date);
				}
				return CellValue;
			}
			else if(cell.getCellTypeEnum()==CellType.BLANK)
			{
				return "";
			}
			else 
			{
				return String.valueOf(cell.getBooleanCellValue());
									
			}
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
			return "Invalid cell data";
		}
		
	}
	public void getColumnValues(String sheetName, String colunmName) {
		sheet = book.getSheet(sheetName);
		row= sheet.getRow(0);
		int col_num=-1;
		double val;
		for(int i=0;i<row.getLastCellNum();i++)
		{
			if(row.getCell(i).getStringCellValue().trim().equals(colunmName)) {
			col_num=i;
			break;
			}
		}
		int rowCount=sheet.getLastRowNum();
		System.out.println(rowCount);
		
		for(int j=1;j<rowCount+1;j++) {
			row= sheet.getRow(j);
			val=row.getCell(col_num).getNumericCellValue();
			System.out.println(val);
		}
	}
	public void getExcelValues(String sheetName) {
		sheet = book.getSheet(sheetName);
		//row= sheet.getRow(0);
		
		
		int rowCount= sheet.getLastRowNum();
		System.out.println("rowCount="+rowCount);
		for(int i=0;i<rowCount+1;i++)
		{
			row= sheet.getRow(i);
			System.out.println("current row = "+i);
			int col_num=row.getLastCellNum();
			System.out.println("col_num="+col_num);
			for(int j=0;j<col_num;j++)
			{
				cell=row.getCell(j);
				//String cell1=row.getCell(j).getStringCellValue();
				
				if(cell.getCellTypeEnum()== CellType.STRING) {
					
					System.out.println(cell.getStringCellValue());
				}else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA)
					{
						String CellValue=String.valueOf(cell.getNumericCellValue());
						if(HSSFDateUtil.isCellDateFormatted(cell))
						{
							DateFormat dr= new SimpleDateFormat("dd/MM/yyyy");
							Date date=cell.getDateCellValue();
							CellValue=dr.format(date);
						}
						System.out.println(CellValue);
					}
					else if(cell.getCellTypeEnum()==CellType.BLANK)
					{
						System.out.println("blank value");
					}
					else 
					{
						System.out.println("invalid value");
											
					}
				}
				
			}
			
		}
}
