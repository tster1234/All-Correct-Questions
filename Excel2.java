package utilities;

//public class Excel2 {
	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class Excel2 {
		public static String test(int row, int cell, String Sheetvalue) throws  IOException {
			FileInputStream obj = new FileInputStream(" ");
			String value = WorkbookFactory.create(obj).getSheet(Sheetvalue).getRow(row).getCell(cell).getStringCellValue();
			return value;
			
		}



}
