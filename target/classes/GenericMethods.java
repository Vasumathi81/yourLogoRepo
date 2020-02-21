package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class GenericMethods {
	
	public Properties properties = new Properties();

	// ***** Method to load the config.properties file and retrieve value from the file *****	
	public String getValueFromPropertiesFile(String parameter) throws IOException {
		
		// create an instance for the inbuilt Properties class
		//Properties properties = new Properties();

		// create an object for the FileInputStream to point to the file to be used
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/config.properties");

		// connecting the properties and fis object to access the available in-built methods
		properties.load(fis);

		// assign the retrieved value from the parameter file to a variable
		String value = properties.getProperty(parameter);
		return value;
	}
	
	// ***** Method to check if an element exists or not ***** 
	public Boolean isElementPresent(WebElement elementName)
	{
		Boolean returnValue = true;
		try {
			if (elementName.isDisplayed())
			{
				returnValue = true;
			}
		} catch (NoSuchElementException e) 
		{
			returnValue = false;
		}
		
		return returnValue;
		
	}
	
	/* *****  Method to import values from excel sheet - pass arguments Sheetname and the Column name to be 
	retrieved***** */
	public ArrayList<String> getValuesFromExcel(String sheetName, String colName) throws IOException
	{
		// declare an array list to save the retrieved values
		ArrayList<String> arrValues = new ArrayList<String>();
		//Properties properties = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/yourLogoDatas.xlsx");
		
		
		// loading the reqd sheet and initializing the row iterator
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		Iterator<Row> rowIT = sheet.iterator();	
		// set the row iterator at first row
		Row rowNum = rowIT.next();	
		
		// initialize the cell iterator
		Iterator<Cell> cellIT = rowNum.cellIterator();

		int colNum = 0;
		// This while loop is getting the column num for the sent columnname									
		while (cellIT.hasNext())
		{
			Cell cell = cellIT.next();
			if (cell.getStringCellValue().equalsIgnoreCase(colName))
			{
				colNum = cell.getColumnIndex();
			}

		}		
		
		// this loop retrieves all the values from the required column and stores it in an array list		
		while (rowIT.hasNext())
		{
			rowNum = rowIT.next();
			if (!rowNum.getCell(colNum).getStringCellValue().isEmpty())
			{
			arrValues.add(rowNum.getCell(colNum).getStringCellValue());
			}
			else
			{
				break;
			}
		}
		
		wb.close();	
		return arrValues;
				
	}
	

	//***** Method to retrieve a cell value when the sheet name, row name, column name arg are sent ***** 
	public String getValuesFromExcel(String sheetName, String rowName, String colName) throws IOException
	{
		String returnVal = null;
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/yourLogoDatas.xlsx");
				
		// loading the reqd sheet and initializing the row iterator
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName);
		Iterator<Row> rowIT = sheet.iterator();	
		// set the row iterator at first row
		Row rowCheck = rowIT.next();	
		
		// initialize the cell iterator
		Iterator<Cell> cellIT = rowCheck.cellIterator();
		
		//This loop will find the row number for the sent row name
		int rowNum=0;
		while (rowIT.hasNext())
		{
			rowCheck = rowIT.next();
			if (rowCheck.getCell(0).getStringCellValue().equalsIgnoreCase(rowName))
			{
				rowNum = rowCheck.getRowNum();
			}
		}

		int colNum = 0;
		// This while loop is getting the column num for the sent column name									
		while (cellIT.hasNext())
		{
			Cell cellCheck = cellIT.next();
			if (cellCheck.getStringCellValue().equalsIgnoreCase(colName))
			{
				colNum = cellCheck.getColumnIndex();
			}

		}		
				
		String cellTypeValue = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getCellType().toString();
		
		// If the retrieved value is numeric, retrieve its raw value
		if (cellTypeValue == "STRING")
		{
			returnVal = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
		}
		else if (cellTypeValue == "NUMERIC")
		{
			returnVal = wb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getRawValue();
		}			
		
		wb.close();
		return returnVal;
				
	}
		
	
	
	

}



