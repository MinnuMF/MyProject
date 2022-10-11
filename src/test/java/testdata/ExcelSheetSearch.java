package testdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheetSearch {
	public static Workbook book;
	public static Sheet sheet;  //import ss
	
	//fetch data from excel sheet
	public static Object[][] readdata(String sheetname)
	{
		FileInputStream file=null;  //initially not refering to any object
		try
		{	
			//read data from excel sheet
			file=new FileInputStream("C:\\Users\\minnu\\eclipse-workspace\\AmazonProject\\src\\test\\java\\testdata\\Searchdata.xlsx");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		//1.create workbook
		try
		{
			//workbookfactory will auto detect  different extensions(xls,xlsx) & create workbook
		book= WorkbookFactory.create(file); //refer all methods from interface Workbook & create a file
		}
		catch(IOException a)
		{
			a.printStackTrace();
		}
		//read sheet from workbook
		sheet=book.getSheet(sheetname); // get the sheet name from workbook, sheetname that is passed in method
		//read rows and columns
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];	//get no of rows &columns
		for(int i=0; i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
			{   //read data from cell 
				data[i][j]=sheet.getRow(i+1).getCell(j).toString(); //get row i+1,read cell & convert it to string
				
			}
		}
		return data;
	
	}
	
}
