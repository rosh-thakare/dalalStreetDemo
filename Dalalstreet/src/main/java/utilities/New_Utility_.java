package utilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class New_Utility_
{
	String path = "C:\\Users\\PERSONAL\\eclipse-workspace\\007_DalalStreetDemo\\src\\test\\resources\\TestData\\DalalStreetTestData.xlsx";
	File file;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFCell cell;
	String data;

	public String readData1 (String sheet_name, int row_index, int cell_index )
	{
		try
		{
			file = new File (path);
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
			cell = wb.getSheet(sheet_name).getRow(row_index).getCell(cell_index);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		//-----------------------------------------------------------------
		try
		{
			data = cell.getStringCellValue();
		}
		catch (Exception e)
		{
			double data1 = cell.getNumericCellValue();
			data = NumberToTextConverter.toText(data1);
		}
		return data;
	}
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
	public static void main(String[] args) {
		New_Utility_ obj = new New_Utility_();
		System.out.println(obj.readData("Login", 0, 0));
	}

}
