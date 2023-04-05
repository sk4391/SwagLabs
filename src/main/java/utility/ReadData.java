package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
   public static String readPropertyFile(String value) throws IOException
   {
	   Properties p = new Properties();
	   FileInputStream file = new FileInputStream("C:\\Users\\khama\\testingpractice\\ProjectSwagLab\\TestData\\config.properties");
	   p.load(file);
	   return p.getProperty(value);
	   
	}
   
    public static String getExcelData(int row,int col) throws EncryptedDocumentException, IOException
    {
    	FileInputStream file = new FileInputStream("C:\\Users\\khama\\testingpractice\\ProjectSwagLab\\TestData\\TestDatas.xlsx");
    	Sheet excelSheet = WorkbookFactory.create(file).getSheet("Sheet1");
    	String value = excelSheet.getRow(row).getCell(col).getStringCellValue();
    	return value;
    }
}
