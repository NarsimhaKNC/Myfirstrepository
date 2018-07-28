package selenium;
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

public class practice3 {
	/*public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Divya\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		String str2="file:\\C:\\Users\\Divya\\Documents\\fourthpractice.html";
		driver.get(str2);
		String str3="NARSIMHA";
		System.out.println("title of the page is:" +str3);
		
		driver.findElement(By.xpath("//*[contains(text(),'80')]/../preceding-sibling::tr/th[contains(text(),'Age')]")).click();
		*/

		public static void main(String[] args){
			String Filepath=".\\Book1.xlsx";
			
			try {
				FileInputStream file= new FileInputStream(Filepath);
				
				
				XSSFWorkbook wb = new XSSFWorkbook(file);
				//XSSFSheet sh = wb.getSheetAt(0);
				XSSFSheet sh = wb.getSheet("Sheet1");
				
				//System.out.println(sh.getRow(11).getCell(5).getStringCellValue());
				
				//sh.getRow(4).getCell(5).setCellValue("na");
				  sh.createRow(11).createCell(5).setCellValue("HHH");
				  
				  sh.getRow(11).createCell(9).setCellValue("hyd");
				  sh.createRow(20).createCell(19).setCellValue("NALGONDA");
				  sh.createRow(20);
				  if(sh.getRow(40)==null){
					  sh.createRow(40).createCell(5).setCellValue("NLG");
				  }
				  if(sh.getRow(29)==null){
					  sh.createRow(29).createCell(10).setCellValue("Testing");
					  		
				  }
				  if(sh.getRow(19)==null){
					  //sh.getRow(19).createCell(11);
					  sh.createRow(19).createCell(11).setCellValue("Automaton");
				  }
				  System.out.println(sh.getRow(5).getRowNum());
				  System.out.println(sh.getRow(4).getLastCellNum());
				System.out.println(sh.getRow(4).getCell(5).getStringCellValue());
				FileOutputStream fout=new FileOutputStream(Filepath);
				wb.write(fout);
				/*fout.flush();
				fout.close();*/
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	

		}
