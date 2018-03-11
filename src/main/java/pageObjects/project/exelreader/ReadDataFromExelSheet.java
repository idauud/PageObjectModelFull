package pageObjects.project.exelreader;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadDataFromExelSheet {
	
	
	public static void main(String [] args) {
		
		ReadDataFromExelSheet rd = new ReadDataFromExelSheet();
		String[][] data =rd.getExelData("C:\\eclipse-workspace\\project\\src\\main\\java\\pageObjects\\project\\data\\testData.xlsx", "testDat");
		System.out.println(data);
		
	}

	
	//@SuppressWarnings({ "resource", "deprecation" })
	public String[][] getExelData(String exelPath, String sheetName) {
		String[][] dataSets = null;
	
		try {
			
			
			//File file =;
			FileInputStream fis = new FileInputStream(new File(exelPath));
			//FileInputStream fis = new FileInputStream(exelPath);
			
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			XSSFSheet sheet = workbook.getSheet(sheetName);
			int totalRow = sheet.getLastRowNum();
			System.out.println(totalRow);
			int totalCol = sheet.getRow(0).getLastCellNum();
			
			System.out.println(totalCol);
			dataSets = new String[totalRow][totalCol];

			// iterate through each row one by one
			Iterator<Row> rowIterator = sheet.iterator();

			int i = 0;
			while (rowIterator.hasNext()) {

				//i++;
				Row row = rowIterator.next();

				// for each row iterate through all the coloumn

				Iterator<Cell> cellIterator = row.cellIterator();
				int j = 0;

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					if (cell.getStringCellValue().equalsIgnoreCase("user")) {

						break;
					}

					switch (cell.getCellType()) {

					case Cell.CELL_TYPE_NUMERIC:
						dataSets[i-1][j++] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;

					case Cell.CELL_TYPE_STRING:

						dataSets[i-1][j++] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;

					case Cell.CELL_TYPE_BOOLEAN:

						dataSets[i-1][j++] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;

					case Cell.CELL_TYPE_FORMULA:

						dataSets[i-1][j++] = cell.getStringCellValue();
						System.out.println(cell.getStringCellValue());
						break;

					}

				}
				i++;
				System.out.println("");

			}
			fis.close();
			return dataSets;

		}


		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return  dataSets;

	}
}
