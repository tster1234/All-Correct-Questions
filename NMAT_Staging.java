package pom;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import zzusable.Robot;

public class NMAT_Staging {
	
	@FindBy(xpath = "//input[@placeholder='Enter Mobile Number / IMS Pin']")private WebElement username;
	@FindBy(xpath = "//button[text()='Next']")private WebElement next;
	@FindBy(xpath = "//input[@placeholder='Password']")private WebElement password;
	@FindBy(xpath = "//button[text()='Login']")private WebElement login;
	@FindBy(xpath = "//img[@alt='User Image']")private WebElement profile;
	@FindBy(xpath = "//p[text()='Change Program']")private WebElement changeprogram;
	@FindBy(xpath = "(//p[@class=' ml-2 flex-1 font-ibm text-sm  font-normal'])[2]")private WebElement selectprogram;
	@FindBy(xpath = "//button[text()='Done']")private WebElement done;
	@FindBy(xpath = "//div[text()='Test']")private WebElement testtab;
	@FindBy(xpath = "//button[text()='CAT']")private WebElement cattier;
	@FindBy(xpath = "//p[text()='NMAT Tests']")private WebElement nmattier;
	@FindBy(xpath = "(//p[text()='Launch Test'])[8]")private WebElement nmattest;
	@FindBy(xpath = "//div[@class='nmatStyle_bottomButton__qIfIG nmatStyle_pointer__A7e6A']")private WebElement nextnmat;
	@FindBy(xpath = "//input[@class='nmatStyle_pointer__A7e6A']")private WebElement agree;
	@FindBy(xpath = "//div[@class='nmatStyle_bottomButton__qIfIG nmatStyle_pointer__A7e6A']")private WebElement nextagreement;
	@FindBy(xpath ="//input[@id='section0']")private WebElement selectOrder;
	@FindBy(xpath = "//div[@class='nmatStyle_bottomButton__qIfIG nmatStyle_pointer__A7e6A']")private WebElement nextOrder;
	@FindBy(xpath = "(//div[@class='_1jLb9E548zwufQV6HJLX8n'])[1]")private WebElement firstquestion;
	@FindBy(xpath = "//div[@class='nmatStyle_bottomButton__qIfIG nmatStyle_pointer__A7e6A']")private WebElement nextquestion;
	@FindBy(xpath = "//div[text()='I Agree']")private WebElement scrolldown;
	@FindBy(xpath = "//div[@class='nmatStyle_bottomButton__qIfIG nmatStyle_pointer__A7e6A']")private WebElement nextfirstgroup;
	@FindBy(xpath = "(//div[@class='_1jLb9E548zwufQV6HJLX8n'])[2]")private WebElement secondoption;
	@FindBy(xpath = "(//div[@class='_1jLb9E548zwufQV6HJLX8n'])[3]")private WebElement thirdoption;
	@FindBy(xpath = "(//div[@class='_1jLb9E548zwufQV6HJLX8n'])[4]")private WebElement fourthoption;
	@FindBy(xpath = "(//div[@class='_1jLb9E548zwufQV6HJLX8n'])[5]")private WebElement fifthoption;
	@FindBy(xpath = "//div[@class ='nmatStyle_bottomButton__qIfIG nmatStyle_pointer__A7e6A']")private WebElement firstgroupnext;
	@FindBy(xpath = "//div[text()='Scorecard']")private WebElement scorecard;
	@FindBy(xpath = "(//p[text()='Launch Test'])[7]")private WebElement unattemptedtest;
	@FindBy(xpath = "//p[text() ='ADMAT']")private WebElement productionnmat;
	@FindBy(xpath = "//button[@id='menu-button']")private WebElement productionprofile;
	@FindBy(xpath = "//p[text()='Change Program']")private WebElement productionchangeprogram;
	@FindBy(xpath = "(//img[@class=' w-4 h-4 pt-1 cursor-pointer '])[16]")private WebElement productionselectprogram;
	@FindBy(xpath = "//button[text()='Done']")private WebElement productiondone;
	@FindBy(xpath ="(//p[text()='Launch Test'])[2]")private WebElement productionlaunchtest;

	
	
	public NMAT_Staging(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterUsername() {
		username.sendKeys("IMS0000964290");
	}
	
	public void clickOnNext() {
		next.click();
	}
	
	public void enterPassword() {
		password.sendKeys("Mayuri12345");
	}
	
	public void clickOnLoginTab() {
		login.click();
	}
	
	public void clickOnProfileTab() {
		profile.click();
	}
	
	public void clickOnChangeProgram() {
		changeprogram.click();
	}
	
	public void clickOnSelectProgram() {
		selectprogram.click();
	}
	
	public void clickOnDoneTab() {
		done.click();
	}
	
	public void clickOnTestTab() {
		testtab.click();
	}
	
	public void clickOnCATTier() {
		cattier.click();
	}
	
	public void clickOnNMATTier() {
		nmattier.click();
	}
	
	public void clickOnLaunchTest(WebDriver driver) throws InterruptedException {
		nmattest.click();
		
//		Set<String> handler = driver.getWindowHandles();
//		
//		Iterator<String> it = handler.iterator();
//		
//		String ParentWindowId = it.next();
//		System.out.println("Parent ID - " +ParentWindowId);
//		
//		String ChildWindowId = it.next();
//		System.out.println("Child ID - "+ChildWindowId);
		
//		if (it.hasNext()) {
//            String ChildWindowsId = it.next();
//            System.out.println("Child ID - " + ChildWindowsId);
//
//            // Switch to the child window
//            driver.switchTo().window(ChildWindowsId);
//
//            // Print the title of the child window to confirm the switch
//            System.out.println("Title of Child window popup : " + driver.getTitle());
//
//            // Perform actions in the child window if necessary
//
//            // Close the child window after actions are completed
//            driver.close();
//
//            // Switch back to the parent window
//            driver.switchTo().window(ParentWindowId);
//        } else {
//            System.out.println("No child window found!");
//        }
		
//		driver.switchTo().window(ChildWindowId);
//		
//		System.out.println("Title of Child window popup : " +driver.getTitle());	
		
		 Thread.sleep(3000); // You can use WebDriverWait as well

	        // Step 3: Get window handles (main window + new window)
	        String mainWindowHandle = driver.getWindowHandle();
	        Set<String> allWindowHandles = driver.getWindowHandles();
	        Iterator<String> windowIterator = allWindowHandles.iterator();

	        // Switch to the child window
	        while (windowIterator.hasNext()) {
	            String childWindowHandle = windowIterator.next();
	            if (!mainWindowHandle.equalsIgnoreCase(childWindowHandle)) {
	                driver.switchTo().window(childWindowHandle); // Switch to the new window
	                
	                // Step 4: Maximize the child window (optional, if necessary)
	                driver.manage().window().maximize();
	            }
	        }
		
		

                // Perform actions on the new window if needed

                // Close the new window after performing actions
             //   driver.close();

                // Switch back to the main window
              //  driver.switchTo().window(mainWindowHandle);
            }
        
	

	public void switchTheWindow(WebDriver driver) {
		driver.switchTo().window("https://stagingexams.imsindia.com/?test_id=829-n");
		
		driver.manage().window().maximize();
	}
	
	public void nextTab(WebDriver driver ) throws AWTException {
	//	driver.switchTo().window("https://stagingexams.imsindia.com/?test_id=829-n");
	//	driver.manage().
		try {
            // Create an instance of the Robot class
            Robot robot = new Robot();

            // Simulate the 'Alt' + 'Space' keys to open the window menu
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_ALT);

            // Wait a bit for the menu to appear
            Thread.sleep(500);

            // Press the 'x' key to maximize the window
            robot.keyPress(KeyEvent.VK_X);
            robot.keyRelease(KeyEvent.VK_X);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	        }

	        // Perform any actions you need on the popup window
	        // Example: driver.findElement(By.id("popupElement")).click();

	        // Close the popup and switch back to the main window
//	        driver.close(); // Close the popup window
//	        driver.switchTo().window(mainWindowHandle); // Switch back to the main window

	        // Continue interacting with the main window, if necessary
	      //  driver.quit(); // Close the browser session
		
		


	
	public void clickOnNextNMATtab() {
		nextnmat.click();
	}
	
	public void openNewTab(WebDriver driver) {
		Actions a = new Actions(driver);
		a.keyDown(Keys.CONTROL);
		a.sendKeys(Keys.TAB);
		a.keyUp(Keys.CONTROL);
		a.build().perform();
	}
	
	public void clickOnAgreement(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", agree);
		agree.click();
	}
	
	public void clickOnNextAgree() {
		nextagreement.click();
	}
	
	public void clickOnSelectOrder(WebDriver driver) {
	//	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectOrder);
		selectOrder.click();
	}
	
   public void clickOrderNext() {
	   nextOrder.click();
   }
   
   
   public void clickOnFirstQuestion(WebDriver driver) {
	   
	  String questiontext =  firstquestion.getText();
	  System.out.println(questiontext);
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstquestion);
	  firstquestion.click();
   }
   
   public void clickOnNextQuestion() {
	   nextquestion.click();
   }
   
   public void scrollDownPage(WebDriver driver) {
	   JavascriptExecutor id = (JavascriptExecutor)driver;
		id.executeScript("window.scrollBy(1800,1700)",nextagreement);
   }
   
   public void clickOnNextFirstGroupNext() {
	   nextfirstgroup.click();
   }
   
   public void clickOnSecondOption(WebDriver driver) {
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondoption);
	   secondoption.click();
	   
   }
   
   public void clickOnThirdOption(WebDriver driver) {
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", thirdoption);
	   thirdoption.click();
   }
   
   public void clickOnFourthOption(WebDriver driver) {
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fourthoption);
	   fourthoption.click();
   }
   
   public void clickOnFifthOption(WebDriver driver) {
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", fifthoption);
	   fifthoption.click();
   }
   
   public void clickOnFirstGroupNext() {
	   firstgroupnext.click();
   }
   
   public void clickOnScorecard() {
	   scorecard.click();
   }
   
   public void alterPopup(WebDriver driver) {
	   Alert alert = driver.switchTo().alert();
	   alert.accept();
   }
   
   public void clickOnUnattemptedPanaltyTest() {
	   unattemptedtest.click();
   }
   
   public void clickOnProductionNMAT() {
	   productionnmat.click();
   }
   
   public void clickOnProductionProfile() {
	   productionprofile.click();
   }
   
   public void clickOnProductionChangeProgram() {
	   productionchangeprogram.click();
   }
   
   public void selectProductionProgram(WebDriver driver) {
	   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", productionselectprogram);
	   productionselectprogram.click();
   }
   
   public void clickOnProductionDone() {
	   productiondone.click();
   }
   
   public void clickOnProductionLaunchTest(WebDriver driver) throws InterruptedException {
	   productionlaunchtest.click();
	   
	   Thread.sleep(3000); // You can use WebDriverWait as well

       // Step 3: Get window handles (main window + new window)
       String mainWindowHandle = driver.getWindowHandle();
       Set<String> allWindowHandles = driver.getWindowHandles();
       Iterator<String> windowIterator = allWindowHandles.iterator();

       // Switch to the child window
       while (windowIterator.hasNext()) {
           String childWindowHandle = windowIterator.next();
           if (!mainWindowHandle.equalsIgnoreCase(childWindowHandle)) {
               driver.switchTo().window(childWindowHandle); // Switch to the new window
               
               // Step 4: Maximize the child window (optional, if necessary)
               driver.manage().window().maximize();
           }
   }
   }

}
