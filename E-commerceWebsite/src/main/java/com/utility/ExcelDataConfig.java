package com.utility;
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	
	XSSFSheet sheet;
	public ExcelDataConfig(String excelPath) {
		File src=new File(excelPath);
		
		try {

	        //Create an object of FileInputStream class to read excel file
			FileInputStream fis=new FileInputStream(src);
			// Now get the workBook 
			wb=new XSSFWorkbook(fis);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
	}
	
	public String getData(int sheetNumber, int row,int column) {
		sheet=wb.getSheetAt(sheetNumber);
		/*XSSFCell cell1 = sheet.getRow(row).getCell(column);
		switch (cell1.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			 System.out.println(cell1.getRichStringCellValue().getString());
        
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell1)) {
				return cell1.getDateCellValue();
        } else {
        	return cell1.getNumericCellValue();
        }
        
        
		case Cell.CELL_TYPE_BOOLEAN:
       return cell1.getBooleanCellValue();
      
        
    case Cell.CELL_TYPE_FORMULA:
       return cell1.getCellFormula();
        
    default:
        System.out.println();
     
		}*/
		String data="";
		try {

			 data=sheet.getRow(row).getCell(column).getStringCellValue();
		}catch(Exception e)
		{
			double datsa=sheet.getRow(row).getCell(column).getNumericCellValue();
			Double newData = new Double(datsa);
			int value=newData.intValue();
			data = String.valueOf(value);
		}
		System.out.print(data);
		//return cell1;
		
		return data;
	}
	
	public int getRowCount(int sheetNumber) {
		
		return (wb.getSheetAt(sheetNumber).getLastRowNum()+1);
	}
	
}
