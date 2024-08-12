package com.comcast.crm.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getdatafromExcelfile(String Path,String sheetName , int rowNum, int celNum) throws Throwable {
		FileInputStream file1 = new FileInputStream(Path);
		Workbook Wb = WorkbookFactory.create(file1);
		Sheet sh=Wb.getSheet(sheetName);
		 Wb.close();
		 return sh.getRow(rowNum).getCell(celNum).toString();


	}
	
	public int getRowcount(String sheetName) throws Throwable {
	FileInputStream file1 = new FileInputStream("./resource/Tek3 - Copy.xlsx");
	Workbook Wb = WorkbookFactory.create(file1);
	int rowcount= Wb.getSheet(sheetName).getLastRowNum();
	return rowcount;
	
}
	public void setdatabackToExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable{
		FileInputStream file1 = new FileInputStream("./resource/Tek3 - Copy.xlsx");
		Workbook Wb = WorkbookFactory.create(file1);
		Cell cel = Wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		cel.setCellType(CellType.STRING);
		cel.setCellValue(data);
		
		FileOutputStream fos= new FileOutputStream("./resource/Tek3 - Copy.xlsx");
		Wb.write(fos);
		Wb.close();
	}

}
	
