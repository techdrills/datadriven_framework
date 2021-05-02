package Data_Driven_Tests;

import Utility.excelUtility;

public class readData {

	public static void main(String[] args) {
		
		// to read the data from excel sheet
		
		excelUtility read = new excelUtility("C:\\Users\\Mahesh\\Documents\\dataDriven_TestData.xlsx");
		
		int rowcount = read.getRowCount("loginTestData");
		System.out.println(rowcount);
		
		String fname = read.getCellData("loginTestData", "firstname", 2);
		System.out.println(fname);
		
		String lname = read.getCellData("loginTestData", "lastname", 2);
		System.out.println(lname);
		
		System.out.println("row no = " + rowcount + " " + fname + " "+ lname);
		
		read.addColumn("loginTestData", "status");
		
		read.setCellData("loginTestData", "status", 2, "passed");
	}

}
