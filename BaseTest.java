package utilities;

//public class BaseTest {
	import java.io.File;

	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeSuite;

	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.ExtentTest;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class BaseTest {
		public ExtentReports reports;
		public ExtentTest logger;
		public static WebDriver driver;
		@BeforeSuite
		public void reporter() {
			ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.div")+"report.html"));
			reports = new ExtentReports();
			reports.attachReporter(extent);
			 	
		}
		@AfterMethod
		public void flushResults() {
			reports.flush();
		}
		
			
		

	}



