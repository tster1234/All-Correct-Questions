package utilities;

//public class Excel {
	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class Excel {
		public static String test(int row, int cell,String Sheetvalue) throws EncryptedDocumentException, IOException {
			FileInputStream obj = new FileInputStream("C:\\Users\\Mayuri Patil\\eclipse-workspace\\IMS3_0\\src\\test\\resources\\Book1.xlsx");
			String value = WorkbookFactory.create(obj).getSheet(Sheetvalue).getRow(row).getCell(cell).getStringCellValue();
			return value;
			
		}

		public static double testNumeric(int i, int j, String string) {
			// TODO Auto-generated method stub
			return 0;
		}

	}



