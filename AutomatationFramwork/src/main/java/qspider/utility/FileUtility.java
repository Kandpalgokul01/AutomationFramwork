package qspider.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility{
	
	public String fetchDetailsFromPropertiyFile(String key) throws IOException {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\kandp\\OneDrive\\Desktop\\Manual_QA\\Selenium\\AutomatationFramwork\\src\\test\\resources\\TestData\\property.properties");
		
	   Properties prop = new Properties();
          
	   
	   prop.load(fis);
	   return prop.getProperty(key);
	}
	
	
	public String fetchDataFromRegisterExcelSheet(String sheetname,int rowNum,int cell) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis= new FileInputStream("C:\\Users\\kandp\\OneDrive\\Desktop\\Manual_QA\\Selenium\\AutomatationFramwork\\src\\test\\resources\\TestData\\TestData.xlsx");
		
	    return  WorkbookFactory.create(fis).getSheet(sheetname).getRow(rowNum).getCell(cell).getStringCellValue();
		 
	}


	
}
