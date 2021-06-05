package Data_Driven_Tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class read_data_from_properties_file {

	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		
		FileInputStream input = new FileInputStream("D:\\MAHESH WORKSPACE\\tds\\7.30\\Data Driven Testing Feb\\src\\Test_Data\\config.properties");
		
		prop.load(input);

		String browsers = prop.getProperty("browser");
		System.out.println(browsers);
		
		System.out.println(prop.getProperty("url"));
		
		System.out.println(prop.getProperty("username"));
		
		System.out.println(prop.getProperty("password"));
		
	
		
		
	}

}
