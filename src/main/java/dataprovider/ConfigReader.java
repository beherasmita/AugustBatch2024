package dataprovider;

import java.io.File;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConfigReader {

	public static String getValue(String key)  {
		
		Properties pro = new Properties();
		try {
			pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/configuration/config.properties")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("LOG:FAIL - Unable To Read Config File"+e.getMessage());
		}
		String value= pro.getProperty(key);
		return value;
		
	}
}
