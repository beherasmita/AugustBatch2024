package dataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {
	
	@DataProvider(name="login")
	
	public static Object[][] getUserDetails(){
		System.out.println("LOG:INFO - Generating testdata for Test");
		Object[][] arr= ExcelReader.getDataFromExcel("login_details");
		System.out.println("LOG:INFO - testdata generated");
		return arr;
	}

}
