package mobileLib;
/**
 * @author Vinita Patil
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MobileExcelDataConfig {
	Workbook wb;
	Sheet sheet1;
	int rowcount;
	File src;
	FileInputStream fis;
	FileOutputStream fout;
	int TestCaseRow;
	public MobileExcelDataConfig(String excelPath, String  sheetName) {
		try {
			src = new File(excelPath);
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			//	sheet1 =  wb.getSheetAt(sheetNumber);
			sheet1 = wb.getSheet(sheetName);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
  public String getData(int row, int column){
	  String data=sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
  }
  public int getRowcount() 
	{
		int row = sheet1.getLastRowNum();
		//	row = row+1;
		return row;
	}
  public int getColumncount(int rowNo) 
	{
		int column = sheet1.getRow(rowNo).getLastCellNum();
		return column;
	}
  public String readValue(int row, int column)
	{
		String celltext = sheet1.getRow(row).getCell(column).getStringCellValue();
		return celltext;
	}
  public String readValue(int rowIndex, String colname)
	{
		int colindex = 0;
		for(int i=0;i<getColumncount(rowIndex);i++)
		{
			//System.out.println(row.getCell(i).getStringCellValue().trim());
			if(sheet1.getRow(0).getCell(i).getStringCellValue().equalsIgnoreCase(colname))
			{
				colindex=i;
				break;
			}
		}		
		return readValue(rowIndex, colindex);
	}
		public void writeCell(int rowIndex, int column, String cellText)
		{
			sheet1.getRow(rowIndex).createCell(column).setCellValue(cellText);
			try {
				fout = new FileOutputStream(src);
				wb.write(fout);
			} catch ( Exception e) {
				System.out.println(e.getMessage());
			} 
		}
		public void writeCell(int rowIndex, String columnName, String cellText)
		{
			int columnIndex = 0;
			//System.out.println("The required column name is "+columnName);
			for(int i = 0;i<getColumncount(rowIndex);i++)
			{
				if(sheet1.getRow(16).getCell(i).getStringCellValue().equalsIgnoreCase(columnName))
				{
					columnIndex = i;
					//System.out.println("The column index is "+i);
					break;
				}		
			}
			writeCell(rowIndex, columnIndex, cellText);	
		}
}
