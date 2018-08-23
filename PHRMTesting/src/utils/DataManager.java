package utils;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.Select;
import org.apache.poi.openxml4j.opc.OPCPackage;

import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;

public class DataManager {
	private static final int Numeric1 = 0;
	private static final int STR1 = 0;
	private static final int Numeric11 = 0;
	private static final int STR11 = 0;
	private static final int Numeric111 = 0;
	private static final int Num = 0;
	private static final int ST = 0;
	static XSSFWorkbook wb = null;
	static XSSFWorkbook rb = null;
	static Sheet sh = null;
	static Sheet sh_p = null;
	static Sheet rs = null;
	static FileOutputStream out = null;
	public static int rowNumber;
	
	
	public DataManager(String fileName, String sheet) {

		try {
			wb = (XSSFWorkbook) WorkbookFactory.create(new FileInputStream(fileName));
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
		sh = wb.getSheet(sheet);
		rowNumber = sh.getPhysicalNumberOfRows();
		System.out.println("row number:" +rowNumber);
		//System.out.println(sh.getRow(2).getCell(0).getStringCellValue());
		
	}
	
	public static void RaterWorkBook(String fileName, String sheet) {

		try {
//			rb = (XSSFWorkbook) WorkbookFactory.create(new FileInputStream(fileName));
//			Workbook rb = WorkbookFactory.create(new FileInputStream(fileName));
			Workbook rb = WorkbookFactory.create(new FileInputStream(fileName));
//			Sheet sh = wb.getSheet("Rater");
			rs = rb.getSheet(sheet);
			System.out.println(sh.getRow(2).getCell(0).getStringCellValue());
//			rb = new XSSFWorkbook(OPCPackage.open(fileName));
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			e.printStackTrace();
		}
	  
		//rowNumber = sh.getPhysicalNumberOfRows();

	}

	public static void writeData(int i, double RaterWorkbookPremium) {
		sh.getRow(i).getCell(3).setCellValue(RaterWorkbookPremium);
		try {
//			out = new FileOutputStream(path);
		} catch (Exception e) {

			e.printStackTrace();
		}
		try {
			wb.write(out);
		} catch (IOException e) {

			e.printStackTrace();
		}
		
	}
	public static void readData(int i) {
		
		/*Parameters.username=sh.getRow(1).getCell(0).getStringCellValue();
		Parameters.password=sh.getRow(1).getCell(2).getStringCellValue();
		Parameters.ExcutionFlag=sh.getRow(1).getCell(1).getStringCellValue();*/
		
		Parameters.Package=sh.getRow(i).getCell(2).getStringCellValue();
		Parameters.FirstName=sh.getRow(i).getCell(3).getStringCellValue();
		Parameters.LastName=sh.getRow(i).getCell(4).getStringCellValue();
		Parameters.ExcutionFlag=sh.getRow(i).getCell(1).getStringCellValue();
		Parameters.CompanyName=sh.getRow(i).getCell(5).getStringCellValue();
		
		try {
			Parameters.Val2 = sh.getRow(i).getCell(6).getStringCellValue();
			
			
			//Parameters.Employees=sh.getRow(2).getCell(6).getStringCellValue();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//System.out.println(sle.getFirstSelectedOption().getText());
			//sle.selectByIndex(1);
			//sle.selectByValue("2");
			//sle.selectByVisibleText("Automotive");
			Parameters.Industry=sh.getRow(i).getCell(7).getStringCellValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Parameters.Title=sh.getRow(i).getCell(8).getStringCellValue();
		Parameters.BEmail=sh.getRow(i).getCell(9).getStringCellValue();
		Parameters.Val1 = sh.getRow(i).getCell(10).getStringCellValue();
		
			//Parameters.PhoneNo=(Double) sh.getRow(2).getCell(10).getNumericCellValue();
			
		
		Parameters.Couponcode=sh.getRow(i).getCell(11).getStringCellValue();
		Parameters.Country=sh.getRow(i).getCell(12).getStringCellValue();
		Parameters.State=sh.getRow(i).getCell(13).getStringCellValue();
		
	}

	public static void readData1(int j) {
		
		Parameters.Package=sh.getRow(j).getCell(2).getStringCellValue();
		Parameters.FirstName=sh.getRow(j).getCell(3).getStringCellValue();
		Parameters.LastName=sh.getRow(j).getCell(4).getStringCellValue();
		Parameters.ExcutionFlag=sh.getRow(j).getCell(1).getStringCellValue();
		Parameters.CompanyName=sh.getRow(j).getCell(5).getStringCellValue();
		
	}
	public static String readData(int rowNumber, int cellNumber) {
		String cellValue = null;
		try {
			cellValue = sh.getRow(rowNumber).getCell(cellNumber).getStringCellValue();

		} catch (Exception e) {
		}

		return cellValue;
	}
	
public static void writeRateBook(String path, int row, int cell, String value) {
		
	rs.getRow(row).createCell(cell).setCellValue(value);
		try {
			out = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			rb.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void writeData(String path, int row, int cell, String value) {
		
		sh.getRow(row).createCell(cell).setCellValue(value);		

		try {
			out = new FileOutputStream(path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			wb.write(out);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	public static void writeData(String path, int row, int cell, String value, String Sheet_Name) {
		try {
			sh_p = wb.getSheet(Sheet_Name);
			sh_p.getRow(row).createCell(cell).setCellValue(value);
		} catch (Exception e1) {
			System.out.println("Failed to create the object to sheet");
			e1.printStackTrace();
		}		

		try {
			out = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		try {
			wb.write(out);
		} catch (IOException e) {

			e.printStackTrace();
		}
		try{
			 wb.setForceFormulaRecalculation(true);
		}catch(Exception e){
			
		}

	}
	public static void closeWorkBook() {
		try {
			wb.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void openFile(String path) {
		File file = new File(path);

		if (!Desktop.isDesktopSupported()) {
			System.out.println("Desktop is not supported");
			return;
		}

		Desktop desktop = Desktop.getDesktop();
		if (file.exists())
			try {
				desktop.open(file);
			} catch (IOException e) {

				e.printStackTrace();
			}

	}

}
