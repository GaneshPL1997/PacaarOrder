package packageEL2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MultipleData {

	public static void main(String[] args) throws Exception {

	        String[] headers = {"Test", "Phone", "Email", "City", "State"};  

	        String[] data = {"Test345", "3037736141", "@test.com", "Chennai", "TN"};
	        
	        FileInputStream fis = new FileInputStream("Form.xlsx");
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheetAt(0);
	    
	        Row headerrow =   sheet.getRow(0);
	//     if (headerrow == null) {
			headerrow = sheet.createRow(0);
		//}
	     
	     Row datarow =   sheet.getRow(1);
	     //if (datarow == null) {
	    	 datarow = sheet.createRow(1);	
	//	}

	   for (int i = 0; i < headers.length; i++) {
		
		  headerrow.createCell(i).setCellValue(headers[i]);
		  datarow.createCell(i).setCellValue(data[i]);   
	}
	   fis.close();
	   
	   FileOutputStream fos = new FileOutputStream("Form.xlsx");
	   workbook.write(fos);
	   workbook.close();
	   fos.close();
	   
	     System.out.println("Data updated");
	 }
	
}
