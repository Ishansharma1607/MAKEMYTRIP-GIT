//https://jar-download.com/online-maven-download-tool.php

//<dependency>
//    <groupId>org.apache.poi</groupId>
//    <artifactId>poi</artifactId>
//    <version>3.9</version>
//</dependency>
//<dependency>
//     <groupId>org.apache.poi</groupId>
//     <artifactId>poi-ooxml</artifactId>
//     <version>3.9 </version>
//</dependency>

package com.mmt.testcases;

import org.testng.annotations.Test;

import com.baseClass.BeforeAndAfterMethod;
import com.baseClass.Keywords;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelKeyIntegration extends BeforeAndAfterMethod {
	
	Keywords key;
	
	@Test(dataProvider = "dp")
	public void f(String excelkey, String locatorT, String locatorV, String data) throws IOException {
		 key = new Keywords(driver);
		
		 if (excelkey.equals("selectFromDropDown"))
			key.selectDropDown(locatorT, locatorV, data);
		else if (excelkey.equals("clickloginlink"))
			key.click(locatorT, locatorV);
		else if (excelkey.equals("getSnap"))
			key.takeSnap(data);
		else
			System.out.println("Invalid Key");

	}

	// internal ExcelSheet used for Data Driven Testing
	@DataProvider
	public Object[][] dp() throws IOException {
		int row = 6;
		int col = 4;
		Object data[][] = new Object[row][col];
//    data[0][0]="keyword";
//    data[0][1]="locatorType";
//    data[0][2]="locatorValue";
//    data[0][3]="data";
		FileInputStream fil = new FileInputStream(new File("C:\\Users\\ishan\\OneDrive\\Desktop\\ReadData.xlsx"));

		XSSFWorkbook workbook = new XSSFWorkbook(fil);
		XSSFSheet sh = workbook.getSheetAt(0); // Sheet

		// Copying data from Excel Sheet & Keeping inside 2D array

		for (int i = 0; i < row; i++) {
			data[i][0] = sh.getRow(i + 1).getCell(0).toString();
			data[i][1] = sh.getRow(i + 1).getCell(1).toString();
			data[i][2] = sh.getRow(i + 1).getCell(2).toString();
			data[i][3] = sh.getRow(i + 1).getCell(3).toString();

		}

		return data;

	}
	
	
	
	
}
