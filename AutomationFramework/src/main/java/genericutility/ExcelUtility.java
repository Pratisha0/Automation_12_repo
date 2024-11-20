package genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author pratisha
 */

public class ExcelUtility {
	
	/**
	 * This method is used to read string data from excel
	 * User must pass sheetname, rowIndex, coloumn index
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return
	 * @throws IOException
	 * @throws EncryptedDocumentException
	 */
	public String getStringDataFromExcel(String sheetName,int rowIndex,int colIndex) throws IOException,EncryptedDocumentException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/testdata2.xlsx");
		 Workbook workbook = WorkbookFactory.create(fis);
		 return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();
	}
	public boolean getBooleanDataFromExcel(String sheetName,int rowIndex,int colIndex) throws IOException,EncryptedDocumentException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/testdata2.xlsx");
		 Workbook workbook = WorkbookFactory.create(fis);
		 return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
	}
	public double getNumericDataFromExcel(String sheetName,int rowIndex,int colIndex) throws IOException,EncryptedDocumentException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData/testdata2.xlsx");
		 Workbook workbook = WorkbookFactory.create(fis);
		 return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
	}

}
