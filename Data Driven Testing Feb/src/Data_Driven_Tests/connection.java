package Data_Driven_Tests;


import Utilities.excelUtility;

public class connection {

	public static void main(String[] args) {
		
		excelUtility reader = new excelUtility("D:\\MAHESH WORKSPACE\\tds\\7.30\\Data Driven Testing Feb\\src\\Test_Data\\login_test_data.xlsx");
		
		// getting count of all rows
		int rows = reader.getRowCount("login data");
		System.out.println(rows);
		
		
		// reading the data from excel sheet
		String username1 = reader.getCellData("login data", "username", 2);
		String password1 = reader.getCellData("login data", "password", 2);
//		System.out.println(username1);
//		System.out.println(password1);
		
		
		// reading the all data from excel using loop
		for(int i=2; i<=rows; i++) {
			String username = reader.getCellData("login data", "username", i);
			String password = reader.getCellData("login data", "password", i);
			
			System.out.println(username + " | " + password);
		}
		
		
		
	}

}
