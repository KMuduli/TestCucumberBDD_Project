package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import managers.FileReaderManager;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/functionalTests", glue= {"stepDefinitions"},
  monochrome = false,
  plugin = {"pretty", "html:target/HtmlReports/HtmlReports.html","json:target/JsonReports/Report.json","junit:target/JunitReports/Report.xml",
   "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}//target/cucumber-reports/report.html
   	)

public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
	    Reporter.setSystemInfo("Selenium", "3.7.0");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", "1.8.0_151");
	}
}
