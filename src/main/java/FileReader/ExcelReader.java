package FileReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Modules.ErrorHandling;




public class ExcelReader {


	/**
	 *
	 * @param path
	 * @return
	 */
	public static String[][] XslxReader(String path){
		String[][] data = null;
		XSSFRow row;
	    XSSFCell cell;
		
		try {
			FileInputStream EXfile = new FileInputStream(path);
			XSSFWorkbook excelreader = new XSSFWorkbook(EXfile);
			
		for(int i = 0 ; i <	excelreader.getNumberOfSheets() ;i++ ) {
			
			XSSFSheet sheet = excelreader.getSheetAt(i);
			int rows = sheet.getPhysicalNumberOfRows();
			int cells = sheet.getRow(i).getPhysicalNumberOfCells();
				
			data = new String[rows][cells];
				
			for(int j = 0 ; j < rows ; j++ ) {
				
		
				row = sheet.getRow(j);
				 if (row != null) {
				
				for(int y = 0 ; y < cells ; y++) {
					
					cell = row.getCell(y);
					//data[j][y] = sheet.getActiveCell();
					
					switch(cell.getCellType()) {
					
					case XSSFCell.CELL_TYPE_STRING :
						data[j][y] = cell.getStringCellValue();
						break;
						
					case XSSFCell.CELL_TYPE_NUMERIC :
						data[j][y] = "" + cell.getNumericCellValue();
						break; 
						
					case XSSFCell.CELL_TYPE_FORMULA :
						data[j][y] = cell.getCellFormula();
						break;
						
					case XSSFCell.CELL_TYPE_ERROR :
						data[j][y] = "" + cell.getErrorCellValue();
						break;
						
					case XSSFCell.CELL_TYPE_BOOLEAN :
						data[j][y] = "" + cell.getBooleanCellValue();
						break;	
						
					case XSSFCell.CELL_TYPE_BLANK :
						data[j][y] = "[BLANK]";
						
						break;
					
					}
					
					
					
					
					
				}//for cells
			   }//for condition
			}//for rows	
		}//for sheets
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			ErrorHandling.FileNotFoundExceptionHandling(e);
		} catch (IOException e) {
			// TODO /Auto-generated catch block
			ErrorHandling.IOExceptionHandling(e);
		}
		
		
		
		
		
		
		return data;
	}
	
	
}
