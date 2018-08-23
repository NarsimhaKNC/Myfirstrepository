package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
//import com.monitorjbl.xlsx.StreamingReader;

public class RateWorkBook {

	public static double automatic_Coverage(String BuildingPremium, String ContentsPremium,String Limit,double IndustryCode, double RateBookPremium) {
		try {
			
			RateBookPremium = -1;
			String filename = "\\\\NBFC.COM\\departments\\QA\\IRCA Automation\\RateTesting\\TestData\\Automatic.xlsm";
			Workbook wb = WorkbookFactory.create(new FileInputStream(filename));
			Sheet sh = wb.getSheet("Rater");
			int str=0;
			System.out.println(Limit);
			try{
				str = Integer.parseInt(Limit.replace(",", ""));	
			}catch(Exception e){
				System.out.println(str);
			}
			
			System.out.println(str);
			sh.getRow(11).getCell(2).setCellValue(str);
			
//			sh.getRow(11).getCell(2).setCellValue(1000000);
//			objFormulaEvaluator.evaluate(sh.getRow(18).getCell(2));
//			objFormulaEvaluator.evaluate(sh.getRow(11).getCell(2));
			
			
			sh.getRow(9).getCell(2).setCellValue(BuildingPremium);	
			sh.getRow(10).getCell(2).setCellValue(ContentsPremium);
			sh.getRow(12).getCell(2).setCellValue(IndustryCode);
			
			//sh.getRow(18).getCell(2).setCellValue("$"+Limit);
		
			Thread.sleep(4000);
			XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
			Thread.sleep(4000);		 
			FileOutputStream out = new FileOutputStream(filename);
			wb.write(out);	
			Thread.sleep(8000);
			System.out.println(sh.getRow(12).getCell(8).getNumericCellValue());
			RateBookPremium = sh.getRow(13).getCell(8).getNumericCellValue();
			System.out.println("Actuarial Start Premium =" + RateBookPremium);
			out.close();
			wb.close();
			System.out.println("End");
			return RateBookPremium;
		} catch (Exception e) {

		}
		return RateBookPremium;

	}
}
