package utilities;

//public class Screenshot {
	import java.io.File;
	import java.io.IOException;
	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;

	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.io.FileHandler;

	public class Screenshot {
		public static String takeScreenshot(WebDriver driver, String name) throws IOException  {
			String i = Screenshot.date();
			
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			File destination = new File("C:\\Users\\Mayuri Patil\\eclipse-workspace\\IMS3_0\\Screenshot"+name+ " "+i+" .jpg");
			
			FileHandler.copy(source, destination);
			
			return i;			
					
		}
		public static String date() {
			DateTimeFormatter obj = DateTimeFormatter.ofPattern("YYYY-MM-DD HH-MM-SS");
			LocalDateTime now = LocalDateTime.now();
			String i = obj.format(now);
			return i;
		}


}
