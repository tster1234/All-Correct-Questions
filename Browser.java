package pojo;

//public class Browser {
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

	public class Browser {
		public static WebDriver openBrowser(String url) {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			options.addArguments("--disable-notifications");
			options.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mayuri Patil\\eclipse-workspace\\MyIMS3_0\\src\\main\\resources\\chromedriver.exe");
			WebDriver driver = new ChromeDriver(options);
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(9,TimeUnit.SECONDS);
			return driver;
			
		}

}
