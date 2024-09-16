package utilities;

//public class Reports {
	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;
	import com.aventstack.extentreports.reporter.configuration.Theme;

	public class Reports {
		public static ExtentReports reports() {
			ExtentSparkReporter htmlReport = new ExtentSparkReporter("extentReport.html");
			ExtentReports reports = new ExtentReports();
			reports.attachReporter(htmlReport);
			reports.setSystemInfo("Env", "Dev");
			reports.setSystemInfo("Testing", "Regression");
			htmlReport.config().setTheme(Theme.DARK);
		//	htmlReport.config().getTimeStampFormat();
		//	htmlReport.config().setTimeStampFormat("dd/MM/yyyy HH:mm:ss");
			htmlReport.config().setDocumentTitle("Sample Automation Report");
			htmlReport.config().setReportName("Sample Automation Report");
		//	htmlReport.config().setProtocol(Protocol.HTTPS);
			return reports;
			
			
			
		}

	}



