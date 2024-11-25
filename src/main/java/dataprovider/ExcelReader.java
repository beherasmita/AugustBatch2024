package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	static XSSFWorkbook wb; // to access in all methods
	//create a method to accept only sheet name and will read complete data of sheet and return 2D object array
	public static Object[][] getDataFromExcel(String sheetName)
	{
		Object [][]arr = null;
		try {
			 wb = new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"./testdata/Data.xlsx")));
			int rows=wb.getSheet(sheetName).getPhysicalNumberOfRows();
			int columns=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
			arr=new Object[rows-1][columns];
			for(int i=1;i<rows;i++)
			{
				
				for(int j=0;j<columns;j++)
				{
					
					//arr[i-1][j]=wb.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
					//instead of above we are calling below function so that data can be of any type
					arr[i-1][j]=getData(sheetName,i,j);
					
				}
				
			}
			
		wb.close();	
			} catch (FileNotFoundException e) {
			System.out.println("file not found");
		} catch (IOException e) {
			System.out.println("unable to read file");
		}
		return arr;
		
	
	} 
	// method to deal with other data type also not only string
	public static String getData(String sheetName,int row,int column)
	{	String data="";
		CellType type=wb.getSheet(sheetName).getRow(row).getCell(column).getCellType();
		if(type==CellType.STRING)
		{
			data=wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}else if(type==CellType.NUMERIC) {
		double value = wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		data=String.valueOf(value);
	}else if(type==CellType.BOOLEAN)
	  {
		  boolean value=wb.getSheet(sheetName).getRow(row).getCell(column).getBooleanCellValue();
		  
		  data=String.valueOf(value);
	  }
	  else if(type==CellType.BLANK)
	  {
		   data="";
	  }
	  return data;


}
}

