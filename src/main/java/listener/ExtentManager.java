package listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import helper.Utility;

public class ExtentManager {
	static ExtentReports report;
	public static ExtentReports getInstance() {
		
		if(report== null) {
			
			return null;
		}
		else {
			return null;
		}
		}
	// below class will create object of ExtentReports
	public static ExtentReports createInstance() {
	// extentsparkreporter is for configuration and 
		//extentreport is for reporting
		//extenttest is for testcases
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/AutomationReport_"+Utility.getCurrentDateTime()+".html");
	sparkReporter.config().setReportName("Automation Report");
	sparkReporter.config().setDocumentTitle("Sprint 1 Report");
	sparkReporter.config().setTheme(Theme.DARK); 
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(sparkReporter);
	
	return extent;
	}
}
