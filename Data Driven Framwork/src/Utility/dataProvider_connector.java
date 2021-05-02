package Utility;

import java.util.ArrayList;

public class dataProvider_connector {
	
	static excelUtility read;
	
	public static ArrayList<Object[]> getDataFromExcel() {
		// code to create one object array
		ArrayList<Object[]> excelData = new ArrayList<Object[]>();
		
		try {
			// we can write all the logical code
			read = new excelUtility("D:\\MAHESH WORKSPACE\\tds\\7.30\\Data Driven Framwork\\src\\testData\\dataProvider_dataDriven.xlsx");
		}
		catch(Exception e) {
			// if any errors / logical mistakes is occured then catch block will catch those errors and print
			// in catach block we dont write logical code, it is only useful for the exception handeler
			e.printStackTrace();
		}
		
		int rowcount = read.getRowCount("loginTestData");
		for(int rownum=2; rownum<= rowcount; rownum++) {
			String username = read.getCellData("loginTestData", "username", rownum);
			String password = read.getCellData("loginTestData", "password", rownum);

			// code to crate object
			Object obj[] = {username,password};
			excelData.add(obj);
		} // for loop code ends
		
		return excelData;	
	}

}
