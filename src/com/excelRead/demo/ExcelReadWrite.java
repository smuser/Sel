package com.excelRead.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {
	
	public static void ReadExcel(String filePath, String fileName, String sheetName) throws IOException
	{
		File file = new File(filePath+"\\"+fileName);
		FileInputStream fileInput = new FileInputStream(file);
		Workbook workbook = null;
		workbook = new XSSFWorkbook(fileInput);
		Sheet sheet = workbook.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
		for(int i=0; i<rowCount+1; i++)
		{
			Row row = sheet.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++)
			{
				System.out.print(row.getCell(j).getStringCellValue()+ " | ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		ExcelReadWrite excel = new ExcelReadWrite();
		String filePath = System.getProperty("user.dir")+"\\src\\excelExportAndFileIO";
		ExcelReadWrite.ReadExcel(filePath,"ExportExcel.xlsx","ReadExcel");
	}

}
