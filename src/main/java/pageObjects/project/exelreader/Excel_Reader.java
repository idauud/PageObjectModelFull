package pageObjects.project.exelreader;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reader {

	public String[][] getExcelData(String path ,String sheetName) {
		 String[][] data = null;
		
		try {
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			
			int totalRows = sheet.getLastRowNum();
			System.out.println(totalRows);
			int totalCol = sheet.getRow(0).getLastCellNum();
			System.out.println(totalCol);
			
			data = new String[totalRows-1][totalCol];
			
			for(int i=1; i<totalRows; i++) {
				
				XSSFRow row = sheet.getRow(i);
				
				for(int j=0; j<totalCol; j++) {
					
					XSSFCell cell = row.getCell(j);
					

					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_NUMERIC:
						data[i-1][j] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;

					case Cell.CELL_TYPE_STRING:

						data[i-1][j] = cell.getStringCellValue();
						//System.out.println(cell.getStringCellValue());
						break;

					case Cell.CELL_TYPE_BOOLEAN:

						data[i-1][j] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;

					case Cell.CELL_TYPE_FORMULA:

						data[i-1][j] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;
						
					}
				}
			}
				
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}


//	public static void main(String[] args) {
//		String path = System.getProperty("user.dir")+"\\src\\main\\java\\pageObjects\\project\\data\\testData.xlsx";
//		String sheetName= "testDat";
//		Excel_Reader obj = new Excel_Reader();
//		
//		String[][] data = obj.getExcelData(path, sheetName);
//		System.out.println(Arrays.deepToString(data));
//
//	}

}