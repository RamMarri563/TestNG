package Excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Apachepractise {
	@DataProvider(name="LoginCredentials")

	public Object[][] testData() throws IOException {
     
		File file= new File("C:\\Users\\Dell\\Desktop\\TestNG1\\practiseTestNG\\src\\test\\resources\\TestData\\Dataprovider.xlsx");
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=wbook.getSheet("Sheet1");
		int noOfRows=sheet.getPhysicalNumberOfRows();
		int noOfColumne=sheet.getRow(0).getLastCellNum();
		Object[][] data=new Object[noOfRows-1][noOfColumne];
		for(int i=1;i<noOfRows-1;i++) {
			for(int j=0;j<noOfColumne;j++) {
				DataFormatter df=new DataFormatter();
				data[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
				//System.out.println(df.formatCellValue(sheet.getRow(i).getCell(j)));
				
			}
		}
		wbook.close();
		fis.close();
		return data;
	
	}

}
