package utilities;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Handling
{
	String path = "C:\\Users\\PERSONAL\\Desktop\\GitHub\\GitHubRepo\\dalalStreetDemo\\Dalalstreet\\src\\test\\java\\testData\\DalalStreetTestData.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	String data;
	
	//=======================================================================================
	//DataFormatter class is used to get all types of data (String, Numeric, Date)
		
		public String readData (String sheet_name, int row_index, int cell_index)
		{
			try
			{
				file = new File(path);
				fis = new FileInputStream(file);
				wb = new XSSFWorkbook (fis);
				cell = wb.getSheet(sheet_name).getRow(row_index).getCell(cell_index);
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			DataFormatter formatter = new DataFormatter();
			String data = formatter.formatCellValue(cell);
			return data;
		}
	//=======================================================================================
	// TO get total count of Rows from sheet
		
		public int getRowCount(String sheet_name)
		{
			try 
			{
				file = new File(path);
				fis = new FileInputStream(file);
				wb = new XSSFWorkbook(fis);
				sheet = wb.getSheet(sheet_name);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			int rows_count = sheet.getLastRowNum();
			return rows_count;
		}

	//=======================================================================================
	// TO get total count of Rows from sheet
		
		public int getCellNumber(String sheet_name, int row_index)
		{
			try 
			{
				file = new File(path);
				fis = new FileInputStream(file);
				wb = new XSSFWorkbook(fis);
				sheet = wb.getSheet(sheet_name);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
			int cells_count = sheet.getRow(row_index).getLastCellNum();
			return cells_count;
		}
		
	//========================Write Data========================================
		public void writeData(String sheet_name, int row_num, int cell_num, String status) 
		{
		try {
				file = new File(path);
				fis = new FileInputStream(file);
				wb = new XSSFWorkbook(fis);
				row = wb.getSheet(sheet_name).getRow(row_num);
			} 
		
		catch (IOException e) 
			{
				e.printStackTrace();
			}
		
		row.createCell(cell_num).setCellValue(status);
		FileOutputStream fos;
			try
			{
				fos = new FileOutputStream(file);
				wb.write(fos);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
	//=========================================================================
		public static void main(String[] args) {
			Excel_Handling obj = new Excel_Handling();
			System.out.println(obj.readData("Login", 0, 0));
			System.out.println(obj.getRowCount("Login"));
			System.out.println(obj.getCellNumber("Login", 1));
		}
}
