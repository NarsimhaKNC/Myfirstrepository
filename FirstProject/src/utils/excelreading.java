package utils;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class excelreading {
	public static void main(String[] args) {

		String Filepath = ".\\Book2.xlsx";

		try {
			FileInputStream file = new FileInputStream(Filepath);

			XSSFWorkbook wb = new XSSFWorkbook(file);

			// XSSFSheet sh = wb.getSheetAt(0);
			// XSSFSheet sh=wb.getSheetIndex();
			XSSFSheet sh = wb.getSheet("Test1");
			// XSSFSheet sh1=wb.getNumberOfSheets();
			for(int i=0;i<wb.getNumberOfSheets();i++){
				System.out.println(wb.getSheetName(i));
			}
			System.out.println(sh.getRow(2).getCell(0).getStringCellValue());
			sh.createRow(10).createCell(5).setCellValue("nidmanoor");
			sh.createRow(10).createCell(2);
			FileOutputStream fout = new FileOutputStream(Filepath);
			wb.write(fout);
			fout.flush();
			fout.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

	}
}