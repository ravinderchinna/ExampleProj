package dataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Excel {
	
	public static String filePath = "X:\\";
	public static Workbook wb;
	public static Sheet sh;
	
	public static void connectExcel(String fileName,String sheetName) throws BiffException, IOException{
		
		 FileInputStream fi = new FileInputStream(filePath+fileName);
		 wb = Workbook.getWorkbook(fi);
		 sh = wb.getSheet(sheetName);
		
	}
	
	public static int rowsCount(){
		return sh.getRows();
	}

	public static int colsCount(){
		return sh.getColumns();
	}
	
	public static String readDataFromCell(int cnum, int rnum){
		return sh.getCell(cnum,rnum).getContents();
	}
	
	}
