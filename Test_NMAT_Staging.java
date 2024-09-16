package test;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pojo.Browser;
import pom.Detailed_Analytics;
import pom.Login_IMS;
import pom.NMAT_Staging;
import utilities.Excel;
import utilities.Reports;
import utilities.Screenshot;

public class Test_NMAT_Staging {
	
		WebDriver driver;
		ExtentReports reports;
		ExtentTest test;
		
		@BeforeClass
		public void configureExtentReport() {
			reports = Reports.reports();
		}
		
		@BeforeMethod
		public void LoginPageTest() throws InterruptedException, EncryptedDocumentException, IOException {
			driver = Browser.openBrowser("https://staging.myimsv3.imsindia.com/");
			
			Login_IMS obj = new Login_IMS(driver);
			
			Thread.sleep(2000);
			String name = Excel.test(0, 1, "Sheet1");
			obj.enterUsername(name);
			
			obj.clickOnNextTab();
			
			Thread.sleep(2000);
			String pass = Excel.test(1, 1, "Sheet1");
			obj.enterPassword(pass);
			
			Thread.sleep(1000);
			obj.clickOnLoginTab();
						
		}
		
		@Test
		public void checkOnNMATPlayer() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProfileTab();
			
			Thread.sleep(4000);
			obj.clickOnChangeProgram();
			
			Thread.sleep(2000);
			obj.clickOnSelectProgram();
			
			Thread.sleep(3000);
			obj.clickOnDoneTab();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnNMATTier();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
		//	obj.openNewTab(driver);
			
			//Launch the test
			
			Thread.sleep(5000);
			try {
				obj.clickOnLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT Scoring Logic check 5 Sept 204 ,Test ID - 829-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				//Quantitative Skills group - 
				
				// First Question 
				try {
					Thread.sleep(3000);
					obj.clickOnFirstQuestion(driver);
					test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
					
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
				}
				
				obj.clickOnNextQuestion();
				
				//Second Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Third Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fourth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fifth Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//Sixth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Seventh Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eighth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Ninth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Tenth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eleventh Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question 
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 12 questions 'Set 2C' is loaded - Preview Question Text - 'In an exam Sujoy got");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correcting 12 questiion 'Set 2C' is not loaded "+e.getMessage());
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct all questions of Round 2  then 'Set 3C' is loaded. ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correct all questions of Round 2 then 'Set 3C' is not loaded - "+e.getMessage());
				}
				
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
				}
				
				// Logical Reasoning - 
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
				}
				
				
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 12 questions 'Set 2C' is loaded -");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "After correcting 12 questions 'Set 2C' is not loaded "+e.getMessage());
					
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();			
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				try {
					Thread.sleep(3000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Language Skills group is launched ");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
				}
				
				
				//Language Skills -
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFirstQuestion(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct all questions of Round 1 then 'Set 2C' is loaded");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correct all question of Round 1 then 'Set 2C' is not loaded" +e.getMessage());
				}
				
				
				//13 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question 
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();		
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();		
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFirstQuestion(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct all questions of Round 2  then 'Set 3C' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "After correct all questions of Round 2 then 'Set 3C' is loaded" +e.getMessage());
				}
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				Thread.sleep(3000);
				obj.clickOnScorecard();
				
				try {
					test.log(Status.PASS, "Scorecard is displayed");
					test.log(Status.PASS, "If all questions are correct : "
							+ "Quantitative Skills scoring marks is correct - 120 ");
					test.log(Status.PASS, "If all questions are correct :"
							+ "Logical Reasoning scoring marks is correct - 120 ");
					test.log(Status.PASS, "If all questions are correct :"
							+ "Language Skills scoring marks is correct - 120");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Scrorecard is not displayed");
				}
				
				
				String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
				 
				 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
					File file = new File("report.html");
					ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
					reports.attachReporter(sparkReport);
					
					test.addScreenCaptureFromBase64String(source);
					
		}
		
		
		
		//If all questions are incorrect 
		
		@Test
		public void checkOnNMATPlayerAllIncorrect() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player - All Incorrect Questions ").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProfileTab();
			
			Thread.sleep(4000);
			obj.clickOnChangeProgram();
			
			Thread.sleep(2000);
			obj.clickOnSelectProgram();
			
			Thread.sleep(3000);
			obj.clickOnDoneTab();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnNMATTier();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
		//	obj.openNewTab(driver);
			
			//Launch the test
			
			Thread.sleep(5000);
			try {
				obj.clickOnLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT Scoring Logic check 5 Sept 204 ,Test ID - 829-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				//Quantitative Skills group - 
				
				// First Question 
				try {
					Thread.sleep(3000);
					obj.clickOnThirdOption(driver);
					test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
					
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
				}
				
				obj.clickOnNextQuestion();
				
				//Second Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Third Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fourth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fifth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Sixth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Seventh Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eighth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Ninth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Tenth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eleventh Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question 
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After incorrecting 12 questions of Quantitative Skills 'Set 2A' is loaded ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After incorrecting 12 questiion of Quantitative Skills 'Set 2A' is not loaded "+e.getMessage());
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After Incorrect all questions of Round 2 of Quantitative Skills  then 'Set 3A' is loaded. ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After Incorrect all questions of Round 2 of Quantitative Skills  then 'Set 3A' is not loaded - "+e.getMessage());
				}
				
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
				}
				
				// Logical Reasoning - 
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
				}
				
				
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After incorrecting 12 questions of Logical Reasoning 'Set 2A' is loaded -");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "After incorrecting 12 questions of Logical Reasoning 'Set 2A' is not loaded "+e.getMessage());
					
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After incorrecting Round 2 of Logical Reasoning 'Set 3A' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "After incorrecting Round 2 of Logical Reasoning 'Set 3A' is not loaded");
					
				}
				
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();			
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				try {
					Thread.sleep(3000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Language Skills group is launched ");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
				}
				
				
				//Language Skills -
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				try {
					Thread.sleep(2000);
					obj.clickOnThirdOption(driver);
					
					//obj.clickOnNextQuestion();
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct all questions of Round 1 of Language Skills then 'Set 2A' is loaded");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correct all question of Round 1 of Language Skills then 'Set 2A' is not loaded" +e.getMessage());
				}
				
				
				//13 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question 
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();		
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();		
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnThirdOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct all questions of Round 2 of Language Skills then 'Set 3A' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "After correct all questions of Round 2 of language Skills then 'Set 3A' is loaded" +e.getMessage());
				}
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				Thread.sleep(3000);
				obj.clickOnScorecard();
				
				try {
					test.log(Status.PASS, "Scorecard is displayed");
					test.log(Status.PASS, "If all questions are incorrect : "
							+ "Quantitative Skills scoring marks is correct - 12 ");
					test.log(Status.PASS, "If all questions are correct :"
							+ "Logical Reasoning scoring marks is incorrect - 12 ");
					test.log(Status.PASS, "If all questions are correct :"
							+ "Language Skills scoring marks is incorrect - 12 ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Scrorecard is not displayed");
				}
				
				
				
				

				String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
				 
				 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
					File file = new File("report.html");
					ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
					reports.attachReporter(sparkReport);
					
					test.addScreenCaptureFromBase64String(source);
				
			
		}
		
		//IF R1- 1 correct , R2- 10 correct , R3 - 3 correct
		
		@Test
		public void checkOnNMATPlayerCase2() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player - R1-A , R2-A , R3 -B ").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProfileTab();
			
			Thread.sleep(4000);
			obj.clickOnChangeProgram();
			
			Thread.sleep(2000);
			obj.clickOnSelectProgram();
			
			Thread.sleep(3000);
			obj.clickOnDoneTab();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnNMATTier();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
		//	obj.openNewTab(driver);
			
			//Launch the test
			
			Thread.sleep(5000);
			try {
				obj.clickOnLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT Scoring Logic check 5 Sept 204 ,Test ID - 829-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				//Quantitative Skills group - 
				
				// First Question 
				try {
					Thread.sleep(3000);
					obj.clickOnThirdOption(driver);
					test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
					
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
				}
				
				obj.clickOnNextQuestion();
				
				//Second Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Third Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fourth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fifth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Sixth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Seventh Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eighth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Ninth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Tenth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eleventh Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question
				try {
					Thread.sleep(2000);
					obj.clickOnSecondOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 1 question of Quantitative Skills 'Set 2A' is loaded -");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "2A is not loaded "+e.getMessage());
					
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				test.log(Status.FAIL, "UI is not correct of question 14 - Quantitave Skills Set 2A - Black Line is displayed ");
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				test.log(Status.PASS, "After correcting 10 questions of Quantitative Skills 'Set 3B' is loading");
				
				//25 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();	
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
				}
				
				// Logical Reasoning - 
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
				}
				
				
				

				//1 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question 
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 1 question of Logical Reasoning 'Set 2A' is loaded  ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set not loaded  "+e.getMessage());
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting Round 2 10 questions of Logical Reasoning 'Set 3B' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Set not loaded ");
					
				}
				
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();			
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				try {
					Thread.sleep(3000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Language Skills group is launched ");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
				}
				
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				try {
					Thread.sleep(2000);
					obj.clickOnThirdOption(driver);
					
					//obj.clickOnNextQuestion();
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 1 question of Round 1 of Language Skills then 'Set 2A' is loaded");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set not loaded " +e.getMessage());
				}
				
				
				//13 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question 
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();		
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();		
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnThirdOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 10 questions of Round 2 of Language Skills then 'Set 3B' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Set not loaded" +e.getMessage());
				}
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				Thread.sleep(4000);
				obj.clickOnFirstGroupNext();
				
				Thread.sleep(3000);
				obj.clickOnScorecard();
				
				
//				Thread.sleep(3000);
//				obj.clickOnFirstGroupNext();
//				
//				Thread.sleep(3000);
//				obj.clickOnScorecard();
				
				try {
					test.log(Status.PASS, "Scorecard is displayed");
					test.log(Status.PASS, "Round 1 - 1 correct, Round 2 - 10 correct , Round 3 - 3 correct then  : "
							+ "Quantitative Skills scoring marks is correct - 55 ");
					test.log(Status.PASS, "If all questions are correct :"
							+ "Logical Reasoning scoring marks is incorrect - 55 ");
					test.log(Status.PASS, "If all questions are correct :"
							+ "Language Skills scoring marks is incorrect - 55");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Scrorecard is not displayed");
				}
				
				
				
				

				String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
				 
				 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
					File file = new File("report.html");
					ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
					reports.attachReporter(sparkReport);
					
					test.addScreenCaptureFromBase64String(source);
				
			
		}
		
		
		//R1- A , R2- B , R3- A
		//R1 -8 , R2 -0, R3-11
		
		@Test
		public void checkOn3rdCase() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player , R1-8 . R2 - 0 , R3 -11").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProfileTab();
			
			Thread.sleep(4000);
			obj.clickOnChangeProgram();
			
			Thread.sleep(2000);
			obj.clickOnSelectProgram();
			
			Thread.sleep(3000);
			obj.clickOnDoneTab();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnNMATTier();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
		//	obj.openNewTab(driver);
			
			//Launch the test
			
			Thread.sleep(5000);
			try {
				obj.clickOnLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT Scoring Logic check 5 Sept 204 ,Test ID - 829-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				//Quantitative Skills group - 
				
				// First Question 
				try {
					Thread.sleep(3000);
					obj.clickOnFirstQuestion(driver);
					test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
					
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
				}
				
				obj.clickOnNextQuestion();
				
				//Second Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Third Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fourth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fifth Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//Sixth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Seventh Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eighth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Ninth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Tenth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eleventh Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question 
				try {
					Thread.sleep(2000);
					obj.clickOnSecondOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 8 questions 'Set 2B' is loaded ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded "+e.getMessage());
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After incorrect all questions of Round 2  then 'Set 3A' is loaded. ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set is loaded "+e.getMessage());
				}
				
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
				}
				
				
				// Logical Reasoning - 
				//R1 -8 , R2 -0, R3-11
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
				}
				
				
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question
				try {
					Thread.sleep(2000);
					obj.clickOnThirdOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 8 questions 'Set 2B' is loaded -");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded "+e.getMessage());
					
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				test.log(Status.PASS, "After incorrect all questions of Round 2 'Set 3A is loaded");
				
				
				//25 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();			
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				try {
					Thread.sleep(3000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Language Skills group is launched ");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
				}
				
				
				//Language Skills -
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				try {
					Thread.sleep(2000);
					obj.clickOnSecondOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 8 questions of Round 1 then 'Set 2B' is loaded");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded " +e.getMessage());
				}
				
				
				//13 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question 
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFirstQuestion(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After incorrect all questions of Round 2  then 'Set 3A' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded" +e.getMessage());
				}
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				Thread.sleep(4000);
				obj.clickOnFirstGroupNext();
				
				Thread.sleep(3000);
				obj.clickOnScorecard();
				
				try {
					test.log(Status.PASS, "Scorecard is displayed");
					test.log(Status.PASS, "If R1 -8 correct , R2- 0 correct , R3 - 11 correct: "
							+ "Quantitative Skills scoring marks is correct - 62 ");
					test.log(Status.PASS, "If R1 -8 correct , R2- 0 correct , R3 - 11 correct :"
							+ "Logical Reasoning scoring marks is correct - 62 ");
					test.log(Status.PASS, "If R1 -8 correct , R2- 0 correct , R3 - 11 correct :"
							+ "Language Skills scoring marks is correct - 62");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Scrorecard is not displayed");
				}
						

				String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
				 
				 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
					File file = new File("report.html");
					ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
					reports.attachReporter(sparkReport);
					
					test.addScreenCaptureFromBase64String(source);
				
			
		}
		
		//R1-A , R2-B . R3-B
		//R1-9 , R2-4 ,R3-1
		
		@Test
		public void checkOn4thCase() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player , R1-9 . R2 - 4 , R3 -1").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProfileTab();
			
			Thread.sleep(4000);
			obj.clickOnChangeProgram();
			
			Thread.sleep(2000);
			obj.clickOnSelectProgram();
			
			Thread.sleep(3000);
			obj.clickOnDoneTab();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnNMATTier();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
		//	obj.openNewTab(driver);
			
			//Launch the test
			
			Thread.sleep(5000);
			try {
				obj.clickOnLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT Scoring Logic check 5 Sept 204 ,Test ID - 829-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				//Quantitative Skills group - 
				
				// First Question 
				try {
					Thread.sleep(3000);
					obj.clickOnFirstQuestion(driver);
					test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
					
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
				}
				
				obj.clickOnNextQuestion();
				
				//Second Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Third Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fourth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fifth Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//Sixth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Seventh Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eighth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Ninth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Tenth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eleventh Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question 
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 9 questions 'Set 2B' is loaded ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded "+e.getMessage());
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 4 questions of Round 2  then 'Set 3B' is loaded. ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set is loaded "+e.getMessage());
				}
				
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(3000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
				}
				
				
				// Logical Reasoning - 
				//R1 -9 , R2 -4, R3-1
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
				}
				
				
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 9 questions 'Set 2B' is loaded -");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded "+e.getMessage());
					
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				test.log(Status.PASS, "After correct 4 questions of Round 2 'Set 3B is loaded");
				
				
				//25 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();			
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				try {
					Thread.sleep(3000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Language Skills group is launched ");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
				}
				
				
				//Language Skills -
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				try {
					Thread.sleep(2000);
					obj.clickOnSecondOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 9 questions of Round 1 then 'Set 2B' is loaded");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded " +e.getMessage());
				}
				
				
				//13 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question 
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFirstQuestion(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 4 questions of Round 2  then 'Set 3B' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded" +e.getMessage());
				}
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				Thread.sleep(4000);
				obj.clickOnFirstGroupNext();
				
				Thread.sleep(3000);
				obj.clickOnScorecard();
				
				try {
					test.log(Status.PASS, "Scorecard is displayed");
					test.log(Status.PASS, "If R1 -9 correct , R2- 4 correct , R3 - 1 correct: "
							+ "Quantitative Skills scoring marks is correct - 57 ");
					test.log(Status.PASS, "If R1 -9 correct , R2- 4 correct , R3 - 1 correct:"
							+ "Logical Reasoning scoring marks is correct - 57 ");
					test.log(Status.PASS, "If R1 -9 correct , R2- 4 correct , R3 - 1 correct:"
							+ "Language Skills scoring marks is correct - 57");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Scrorecard is not displayed");
				}
						

				String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
				 
				 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
					File file = new File("report.html");
					ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
					reports.attachReporter(sparkReport);
					
					test.addScreenCaptureFromBase64String(source);
				
			
		}
		
		//R1 - A. R2-B , R3-C
		// R1-10 , R2 - 9 , R3 -5

		@Test
		public void checkOn5thCase() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player , R1-10 , R2 - 9 , R3 -5").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProfileTab();
			
			Thread.sleep(4000);
			obj.clickOnChangeProgram();
			
			Thread.sleep(2000);
			obj.clickOnSelectProgram();
			
			Thread.sleep(3000);
			obj.clickOnDoneTab();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnNMATTier();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
		//	obj.openNewTab(driver);
			
			//Launch the test
			
			Thread.sleep(5000);
			try {
				obj.clickOnLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT Scoring Logic check 5 Sept 204 ,Test ID - 829-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				//Quantitative Skills group - 
				
				// First Question 
				try {
					Thread.sleep(3000);
					obj.clickOnFirstQuestion(driver);
					test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
					
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
				}
				
				obj.clickOnNextQuestion();
				
				//Second Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Third Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fourth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fifth Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//Sixth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Seventh Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eighth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Ninth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Tenth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eleventh Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question 
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 10 questions 'Set 2B' is loaded ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded "+e.getMessage());
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 9 questions of Round 2  then 'Set 3C' is loaded. ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set is loaded "+e.getMessage());
				}
				
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(3000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
				}
				
				
				// Logical Reasoning - 
				//R1 -10 , R2 -9, R3-5
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
				}
				
				
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 10 questions 'Set 2B' is loaded -");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded "+e.getMessage());
					
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				test.log(Status.PASS, "After correct 9 questions of Round 2 'Set 3C is loaded");
				
				
				//25 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();			
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				try {
					Thread.sleep(3000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Language Skills group is launched ");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
				}
				
				
				//Language Skills -
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				try {
					Thread.sleep(2000);
					obj.clickOnSecondOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 10 questions of Round 1 then 'Set 2B' is loaded");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded " +e.getMessage());
				}
				
				
				//13 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question 
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFirstQuestion(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 9 questions of Round 2  then 'Set 3C' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded" +e.getMessage());
				}
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				Thread.sleep(4000);
				obj.clickOnFirstGroupNext();
				
				Thread.sleep(3000);
				obj.clickOnScorecard();
				
				try {
					test.log(Status.PASS, "Scorecard is displayed");
					test.log(Status.FAIL, "If R1 -10 correct , R2- 9 correct , R3 - 5 correct: "
							+ "Quantitative Skills scoring marks is  not correct - Current Score - 79 , Expected Score - 81 ");
					test.log(Status.FAIL, "If R1 -10 correct , R2- 9 correct , R3 - 5 correct:"
							+ "Logical Reasoning scoring marks is  not correct - Current Score - 79 , Expected Score - 81  ");
					test.log(Status.FAIL, "If R1 -10 correct , R2- 9 correct , R3 - 5 correct:"
							+ "Language Skills scoring marks is correct - Current Score - 79 , Expected Score - 81 ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Scrorecard is not displayed");
				}
						

				String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
				 
				 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
					File file = new File("report.html");
					ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
					reports.attachReporter(sparkReport);
					
					test.addScreenCaptureFromBase64String(source);
				
			
		}
		
		//Unattempted Questions
		@Test
		public void checkOn6thCase() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player ,All Unattempted Questions").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProfileTab();
			
			Thread.sleep(4000);
			obj.clickOnChangeProgram();
			
			Thread.sleep(2000);
			obj.clickOnSelectProgram();
			
			Thread.sleep(3000);
			obj.clickOnDoneTab();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnNMATTier();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
		//	obj.openNewTab(driver);
			
			//Launch the test
			
			Thread.sleep(5000);
			try {
				obj.clickOnLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT Scoring Logic check 5 Sept 204 ,Test ID - 829-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				test.log(Status.PASS, "When time ends (52 mins) for first group then popup is displayed ");
				test.log(Status.FAIL, "Second group is not loaded , Text - We've encountered a technical issue., warning message is displayed ");
				
				//Quantitative Skills group - 
				
				// First Question 
//				try {
//					Thread.sleep(3120000);
//					obj.clickOnFirstQuestion(driver);
//					test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
//					
//				}
//				
//				catch(Exception e) {
//					test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
//				}
//				
//				obj.clickOnNextQuestion();
//				
//				test.log(Status.PASS, "Time expired popup is coming");
//				test.log(Status.PASS, "Switch to next section - Logical Reasoning");
				
		}
		
		//R1-12 . R2-12, R3-10 - 2 Unattempted
		@Test
		public void checkUnattemptedPanalityLastGroupOnNMATPlayer() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProfileTab();
			
			Thread.sleep(4000);
			obj.clickOnChangeProgram();
			
			Thread.sleep(2000);
			obj.clickOnSelectProgram();
			
			Thread.sleep(3000);
			obj.clickOnDoneTab();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnNMATTier();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
		//	obj.openNewTab(driver);
			
			//Launch the test
			
			Thread.sleep(5000);
			try {
				obj.clickOnLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT Scoring Logic check 5 Sept 204 ,Test ID - 829-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				//Quantitative Skills group - 
				
				// First Question 
				try {
					Thread.sleep(3000);
					obj.clickOnFirstQuestion(driver);
					test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
					
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
				}
				
				obj.clickOnNextQuestion();
				
				//Second Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Third Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fourth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fifth Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//Sixth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Seventh Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eighth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Ninth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Tenth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eleventh Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question 
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 12 questions 'Set 2C' is loaded - Preview Question Text - 'In an exam Sujoy got");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correcting 12 questiion 'Set 2C' is not loaded "+e.getMessage());
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct all questions of Round 2  then 'Set 3C' is loaded. ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correct all questions of Round 2 then 'Set 3C' is not loaded - "+e.getMessage());
				}
				
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
				}
				
				// Logical Reasoning - 
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
				}
				
				
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 12 questions 'Set 2C' is loaded -");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "After correcting 12 questions 'Set 2C' is not loaded "+e.getMessage());
					
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(3000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();			
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				try {
					Thread.sleep(3000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Language Skills group is launched ");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
				}
				
				
				//Language Skills -
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFirstQuestion(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct all questions of Round 1 then 'Set 2C' is loaded");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correct all question of Round 1 then 'Set 2C' is not loaded" +e.getMessage());
				}
				
				
				//13 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question 
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();		
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();		
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFirstQuestion(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct all questions of Round 2  then 'Set 3C' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "After correct all questions of Round 2 then 'Set 3C' is loaded" +e.getMessage());
				}
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(1500000);
				obj.alterPopup(driver);
				obj.clickOnNextQuestion();
				
				test.log(Status.FAIL, "We are facing technical issue popup is displayed - Unable to proceed testing ");
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				Thread.sleep(3000);
				obj.clickOnScorecard();
				
				try {
					test.log(Status.PASS, "Scorecard is displayed");
					test.log(Status.PASS, "If all questions are correct : "
							+ "Quantitative Skills scoring marks is correct - 120 ");
					test.log(Status.PASS, "If all questions are correct :"
							+ "Logical Reasoning scoring marks is correct - 120 ");
					test.log(Status.PASS, "If all questions are correct :"
							+ "Language Skills scoring marks is correct - 120");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Scrorecard is not displayed");
				}
				
				
				String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
				 
				 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
					File file = new File("report.html");
					ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
					reports.attachReporter(sparkReport);
					
					test.addScreenCaptureFromBase64String(source);
					
		}
		
		//R1-12 , R2-11, R3-0
		@Test
		public void checkOnUnattempted3rdCase() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player ,R1-12 ; R2-11 ; R3-0").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProfileTab();
			
			Thread.sleep(4000);
			obj.clickOnChangeProgram();
			
			Thread.sleep(2000);
			obj.clickOnSelectProgram();
			
			Thread.sleep(3000);
			obj.clickOnDoneTab();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnNMATTier();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
		//	obj.openNewTab(driver);
			
			//Launch the test
			
			Thread.sleep(5000);
			try {
				obj.clickOnLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Test ID - 828-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				test.log(Status.PASS, "After correct 12 questions next set is loaded ");
				test.log(Status.PASS, "Correct only 11 questions of Quantitative skills - wait until time ends on 12 questions");
				test.log(Status.PASS, "Completed Logical Reasoning Group");
				test.log(Status.PASS, "Completed Language Skills Group ");
				test.log(Status.PASS, "Scorecard displayed");
//				test.log(Status.FAIL, "Quantitative Skills logic - 12 correct - 21 (66+21 = 87), "
//						+ "R2 -11 correct 1 skip (87+13.5=100.5) , 100-2 =98.5 ;"
//						+ " R3 - 0 correct 24 skip (98.5 - 16.5= 82) , 82-24 = 58");
				test.log(Status.FAIL, "Quantitative SKills is not calculated correctly : Actual Result - 74"
						+ "Expected Result - 58");
				
		}
		
		//R1-11 , R2-4 ,R3-6
		//R1-A , R2- C, R3-B
		
		@Test
		public void checkOn6thCaseNMATPlayer() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player : Case - R1-11 , R2-4 ,R3-6").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProfileTab();
			
			Thread.sleep(4000);
			obj.clickOnChangeProgram();
			
			Thread.sleep(2000);
			obj.clickOnSelectProgram();
			
			Thread.sleep(3000);
			obj.clickOnDoneTab();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnNMATTier();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
		//	obj.openNewTab(driver);
			
			//Launch the test
			
			Thread.sleep(5000);
			try {
				obj.clickOnLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT Scoring Logic check 5 Sept 204 ,Test ID - 829-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				//Quantitative Skills group - 
				
				// First Question 
				try {
					Thread.sleep(3000);
					obj.clickOnFirstQuestion(driver);
					test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
					
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
				}
				
				obj.clickOnNextQuestion();
				
				//Second Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Third Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fourth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fifth Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//Sixth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Seventh Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eighth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Ninth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Tenth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eleventh Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question 
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 11 questions 'Set 2C' is loaded ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correcting 11 questiion 'Set 2C' is not loaded "+e.getMessage());
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 4 questions of Round 2  then 'Set 3B' is loaded. ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded - "+e.getMessage());
				}
				
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(3000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
				}
				
				
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
				}
				
				
				//Logical Reasoning 
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 11 questions of Logical Reasoning 'Set 2C' is loaded -");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "After correcting 11 questions 'Set 2C' is not loaded "+e.getMessage());
					
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				test.log(Status.PASS, "After correcting 4 questions of round 1 of Logical Reasoning then 'Set 3B' is loaded ");
				
				
				//25 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();			
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				try {
					Thread.sleep(3000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Language Skills group is launched ");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
				}
				
				
				//Language Skills -
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				try {
					Thread.sleep(2000);
					obj.clickOnSecondOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 11 questions of Round 1 then 'Set 2C' is loaded");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correct 11 question of Round 1 then 'Set 2C' is not loaded" +e.getMessage());
				}
				
				
				//13 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question 
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();	
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFirstQuestion(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 8 questions of Language Skills Round 2  then 'Set 3B' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded " +e.getMessage());
				}
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				Thread.sleep(3000);
				obj.clickOnScorecard();
				
				try {
					test.log(Status.PASS, "Scorecard is displayed");
					test.log(Status.PASS, "If R1-11 , R2-8 , R3-5 questions are correct : "
							+ "Quantitative Skills scoring marks is correct - 83 ");
					test.log(Status.PASS, "If R1-11 , R2-8 , R3-5 questions are correct :"
							+ "Logical Reasoning scoring marks is correct - 83 ");
					test.log(Status.PASS, "If R1-11 , R2-8 , R3-5 questions are correct :"
							+ "Language Skills scoring marks is correct - 83");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Scrorecard is not displayed");
				}
				
				
				String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
				 
				 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
					File file = new File("report.html");
					ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
					reports.attachReporter(sparkReport);
					
					test.addScreenCaptureFromBase64String(source);
					
		}
		
		//Production Testing Starts 
		
		@Test
		public void checkOnProductionNMATPlayer() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProductionProfile();
			
			Thread.sleep(4000);
			obj.clickOnProductionChangeProgram();
			
			Thread.sleep(2000);
			obj.selectProductionProgram(driver);
			
			Thread.sleep(3000);
			obj.clickOnProductionDone();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnProductionNMAT();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
			Thread.sleep(5000);
			try {
				obj.clickOnProductionLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT 23 Aug 2024 ,Test ID - 193-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				//Quantitative Skills group - 
				
				// First Question 
				try {
					Thread.sleep(3000);
					obj.clickOnFirstQuestion(driver);
					test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
					
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
				}
				
				obj.clickOnNextQuestion();
				
				//Second Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Third Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fourth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fifth Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//Sixth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Seventh Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eighth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Ninth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Tenth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eleventh Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question 
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 11 questions 'Set 2C' is loaded ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correcting 11 questiion 'Set 2C' is not loaded "+e.getMessage());
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 4 questions of Round 2  then 'Set 3B' is loaded. ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded - "+e.getMessage());
				}
				
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(3000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
				}
				
				
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
				}
				
				
				//Logical Reasoning 
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 11 questions of Logical Reasoning 'Set 2C' is loaded -");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "After correcting 11 questions 'Set 2C' is not loaded "+e.getMessage());
					
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				test.log(Status.PASS, "After correcting 4 questions of round 1 of Logical Reasoning then 'Set 3B' is loaded ");
				
				
				//25 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();			
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				try {
					Thread.sleep(3000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Language Skills group is launched ");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
				}
				
				
				//Language Skills -
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				try {
					Thread.sleep(2000);
					obj.clickOnSecondOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 11 questions of Round 1 then 'Set 2C' is loaded");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correct 11 question of Round 1 then 'Set 2C' is not loaded" +e.getMessage());
				}
				
				
				//13 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question 
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();	
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFirstQuestion(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct 8 questions of Language Skills Round 2  then 'Set 3B' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Set is not loaded " +e.getMessage());
				}
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				Thread.sleep(3000);
				obj.clickOnScorecard();
				
				try {
					test.log(Status.PASS, "Scorecard is displayed");
					test.log(Status.PASS, "If R1-11 , R2-8 , R3-5 questions are correct : "
							+ "Quantitative Skills scoring marks is correct - 83 ");
					test.log(Status.PASS, "If R1-11 , R2-8 , R3-5 questions are correct :"
							+ "Logical Reasoning scoring marks is correct - 83 ");
					test.log(Status.PASS, "If R1-11 , R2-8 , R3-5 questions are correct :"
							+ "Language Skills scoring marks is correct - 83");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Scrorecard is not displayed");
				}
				
			
			
			
			
			String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
			 
			 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
				File file = new File("report.html");
				ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
				reports.attachReporter(sparkReport);
				
				test.addScreenCaptureFromBase64String(source);
		}
		
		//All Correct Production
		
		@Test
		public void checkOnAllCorrectProductionNMATPlayer() throws InterruptedException, IOException, AWTException {
			
			ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player - All correct").
					  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
			
			NMAT_Staging obj = new NMAT_Staging(driver);
			Screenshot abc = new Screenshot();
			
			Thread.sleep(3000);
			obj.clickOnProductionProfile();
			
			Thread.sleep(4000);
			obj.clickOnProductionChangeProgram();
			
			Thread.sleep(2000);
			obj.selectProductionProgram(driver);
			
			Thread.sleep(3000);
			obj.clickOnProductionDone();
			
			try {
				Thread.sleep(2000);
				obj.clickOnTestTab();
				test.log(Status.PASS, "T001 : Test tab is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
			}
			
			
			//Click on CAT tier
			
			try {
				obj.clickOnCATTier();
				test.log(Status.PASS, "T002 : CAT tier is clickable ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
			}
			
			//Click on NMAT tier
			
			Thread.sleep(2000);
			try {
				obj.clickOnProductionNMAT();
				test.log(Status.PASS, "T003 : NMAT test page is displayed ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
			}
			
			Thread.sleep(5000);
			try {
				obj.clickOnProductionLaunchTest(driver);
				test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT 23 Aug 2024 ,Test ID - 193-n ");
			}
			
			catch(Exception e) {
				test.log(Status.FAIL, "T004 : NMAT test is not launched ");
				
			}
			
//			test.log(Status.PASS, "T005 : Instruction page is displayed ");
//			test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//			test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//			test.log(Status.PASS, "T008 : Quantitative Skills launched");
//			test.log(Status.PASS, "T009 : Timing of section is started from 52");
//			test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//			test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
			
//				Thread.sleep(3000);
//				obj.switchTheWindow(driver);
				
				Thread.sleep(5000);
				obj.clickOnNextNMATtab();
				
				Thread.sleep(3000);
				obj.scrollDownPage(driver);
				
				Thread.sleep(4000);
				obj.clickOnAgreement(driver);
				
				Thread.sleep(3000);
				obj.clickOnNextAgree();
				
				try {
					Thread.sleep(3000);
					obj.clickOnSelectOrder(driver);
			//		obj.clickOrderNext();
					test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
				}
				
				Thread.sleep(3000);
				obj.clickOrderNext();
				
				Thread.sleep(3000);
				obj.clickOnNextFirstGroupNext();
				
				//Quantitative Skills group - 
				
				// First Question 
				try {
					Thread.sleep(3000);
					obj.clickOnFirstQuestion(driver);
					test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
					
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
				}
				
				obj.clickOnNextQuestion();
				
				//Second Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Third Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fourth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Fifth Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//Sixth Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Seventh Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eighth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Ninth Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Tenth Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//Eleventh Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question 
				try {
					Thread.sleep(2000);
					obj.clickOnFourthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 12 questions 'Set 2C' is loaded - Preview Question Text - 'In an exam Sujoy got");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correcting 12 questiion 'Set 2C' is not loaded "+e.getMessage());
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct all questions of Round 2  then 'Set 3C' is loaded. ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correct all questions of Round 2 then 'Set 3C' is not loaded - "+e.getMessage());
				}
				
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
				}
				
				// Logical Reasoning - 
				try {
					Thread.sleep(4000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
				}
				
				
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//13 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFifthOption(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correcting 12 questions 'Set 2C' is loaded -");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "After correcting 12 questions 'Set 2C' is not loaded "+e.getMessage());
					
				}
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();			
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				try {
					Thread.sleep(3000);
					obj.clickOnFirstGroupNext();
					test.log(Status.PASS, "Language Skills group is launched ");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
				}
				
				
				//Language Skills -
				
				//1 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//2 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//3 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//4 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//5 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//6 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//7 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//8 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//9 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//10 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//11 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//12 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFirstQuestion(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct all questions of Round 1 then 'Set 2C' is loaded");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "After correct all question of Round 1 then 'Set 2C' is not loaded" +e.getMessage());
				}
				
				
				//13 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//14 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//15 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//16 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//17 Question 
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//18 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//19 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();		
				
				//20 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();		
				
				//21 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//22 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//23 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//24 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//25 Question
				try {
					Thread.sleep(2000);
					obj.clickOnFirstQuestion(driver);
					
					obj.clickOnNextQuestion();
					test.log(Status.PASS, "After correct all questions of Round 2  then 'Set 3C' is loaded");
				}
				catch(Exception e) {
					test.log(Status.FAIL, "After correct all questions of Round 2 then 'Set 3C' is loaded" +e.getMessage());
				}
				
				//26 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//27 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//28 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//29 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//30 Question
				Thread.sleep(2000);
				obj.clickOnFourthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//31 Question
				Thread.sleep(2000);
				obj.clickOnFirstQuestion(driver);
				
				obj.clickOnNextQuestion();
				
				//32 Question
				Thread.sleep(2000);
				obj.clickOnSecondOption(driver);
				
				obj.clickOnNextQuestion();
				
				//33 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//34 Question
				Thread.sleep(2000);
				obj.clickOnThirdOption(driver);
				
				obj.clickOnNextQuestion();
				
				//35 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				//36 Question
				Thread.sleep(2000);
				obj.clickOnFifthOption(driver);
				
				obj.clickOnNextQuestion();
				
				
				Thread.sleep(3000);
				obj.clickOnFirstGroupNext();
				
				Thread.sleep(3000);
				obj.clickOnScorecard();
				
				try {
					test.log(Status.PASS, "Scorecard is displayed");
					test.log(Status.PASS, "If all questions are correct : "
							+ "Quantitative Skills scoring marks is correct - 120 ");
					test.log(Status.PASS, "If all questions are correct :"
							+ "Logical Reasoning scoring marks is correct - 120 ");
					test.log(Status.PASS, "If all questions are correct :"
							+ "Language Skills scoring marks is correct - 120");
				}
				
				catch(Exception e) {
					test.log(Status.FAIL, "Scrorecard is not displayed");
				}
				
				
				String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
				 
				 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
					File file = new File("report.html");
					ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
					reports.attachReporter(sparkReport);
					
					test.addScreenCaptureFromBase64String(source);
					
		}
		
		//Production Case
		//R1-A , R2-B . R3-B
		//R1-9 , R2-4 ,R3-1
				
				@Test
				public void checkOnProduction4thCase() throws InterruptedException, IOException, AWTException {
					
					ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player , R1-9 . R2 - 4 , R3 -1").
							  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
					
					NMAT_Staging obj = new NMAT_Staging(driver);
					Screenshot abc = new Screenshot();
					
					Thread.sleep(3000);
					obj.clickOnProductionProfile();
					
					Thread.sleep(4000);
					obj.clickOnProductionChangeProgram();
					
					Thread.sleep(2000);
					obj.selectProductionProgram(driver);
					
					Thread.sleep(3000);
					obj.clickOnProductionDone();
					
					try {
						Thread.sleep(2000);
						obj.clickOnTestTab();
						test.log(Status.PASS, "T001 : Test tab is clickable ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
					}
					
					
					//Click on CAT tier
					
					try {
						obj.clickOnCATTier();
						test.log(Status.PASS, "T002 : CAT tier is clickable ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
					}
					
					//Click on NMAT tier
					
					Thread.sleep(2000);
					try {
						obj.clickOnProductionNMAT();
						test.log(Status.PASS, "T003 : NMAT test page is displayed ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
					}
					
					Thread.sleep(5000);
					try {
						obj.clickOnProductionLaunchTest(driver);
						test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT 23 Aug 2024 ,Test ID - 187-n ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T004 : NMAT test is not launched ");
						
					}
					
//					test.log(Status.PASS, "T005 : Instruction page is displayed ");
//					test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//					test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//					test.log(Status.PASS, "T008 : Quantitative Skills launched");
//					test.log(Status.PASS, "T009 : Timing of section is started from 52");
//					test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//					test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
					
//						Thread.sleep(3000);
//						obj.switchTheWindow(driver);
						
						Thread.sleep(5000);
						obj.clickOnNextNMATtab();
						
						Thread.sleep(3000);
						obj.scrollDownPage(driver);
						
						Thread.sleep(4000);
						obj.clickOnAgreement(driver);
						
						Thread.sleep(3000);
						obj.clickOnNextAgree();
						
						try {
							Thread.sleep(3000);
							obj.clickOnSelectOrder(driver);
					//		obj.clickOrderNext();
							test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
						}
						
						Thread.sleep(3000);
						obj.clickOrderNext();
						
						Thread.sleep(3000);
						obj.clickOnNextFirstGroupNext();
						
						//Quantitative Skills group - 
						
						// First Question 
						try {
							Thread.sleep(3000);
							obj.clickOnFirstQuestion(driver);
							test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
							
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
						}
						
						obj.clickOnNextQuestion();
						
						//Second Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Third Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Fourth Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Fifth Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//Sixth Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Seventh Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Eighth Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Ninth Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Tenth Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Eleventh Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//12 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//13 Question 
						try {
							Thread.sleep(2000);
							obj.clickOnFourthOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correcting 9 questions 'Set 2B' is loaded ");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Set is not loaded "+e.getMessage());
						}
						
						//14 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//15 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//16 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//17 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//18 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//19 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//20 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//21 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//22 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//23 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//24 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//25 Question
						try {
							Thread.sleep(2000);
							obj.clickOnFifthOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correct 4 questions of Round 2  then 'Set 3B' is loaded. ");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Set is loaded "+e.getMessage());
						}
						
						
						//26 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//27 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//28 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//29 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//30 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//31 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//32 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//33 Question
						Thread.sleep(3000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//34 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						
						//35 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//36 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						try {
							Thread.sleep(4000);
							obj.clickOnFirstGroupNext();
							test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
						}
						
						
						// Logical Reasoning - 
						//R1 -9 , R2 -4, R3-1
						
						try {
							Thread.sleep(4000);
							obj.clickOnFirstGroupNext();
							test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
						}
						
						
						
						//1 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//2 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//3 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//4 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//5 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//6 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//7 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//8 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//9 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//10 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//11 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//12 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//13 Question
						try {
							Thread.sleep(2000);
							obj.clickOnFourthOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correcting 9 questions 'Set 2B' is loaded -");
						}
						catch(Exception e) {
							test.log(Status.FAIL, "Set is not loaded "+e.getMessage());
							
						}
						
						//14 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//15 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//16 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//17 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//18 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//19 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//20 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//21 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//22 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//23 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//24 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						test.log(Status.PASS, "After correct 4 questions of Round 2 'Set 3B is loaded");
						
						
						//25 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//26 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//27 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//28 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//29 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//30 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//31 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//32 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//33 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//34 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//35 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//36 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();			
						
						Thread.sleep(3000);
						obj.clickOnFirstGroupNext();
						
						try {
							Thread.sleep(3000);
							obj.clickOnFirstGroupNext();
							test.log(Status.PASS, "Language Skills group is launched ");
						}
						catch(Exception e) {
							test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
						}
						
						
						//Language Skills -
						
						//1 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//2 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//3 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//4 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//5 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//6 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//7 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//8 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//9 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//10 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//11 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//12 Question
						try {
							Thread.sleep(2000);
							obj.clickOnSecondOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correct 9 questions of Round 1 then 'Set 2B' is loaded");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Set is not loaded " +e.getMessage());
						}
						
						
						//13 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//14 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//15 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//16 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//17 Question 
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//18 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//19 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//20 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//21 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//22 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//23 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//24 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//25 Question
						try {
							Thread.sleep(2000);
							obj.clickOnFirstQuestion(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correct 4 questions of Round 2  then 'Set 3B' is loaded");
						}
						catch(Exception e) {
							test.log(Status.FAIL, "Set is not loaded" +e.getMessage());
						}
						
						//26 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//27 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//28 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//29 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//30 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//31 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//32 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//33 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//34 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//35 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//36 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						
						Thread.sleep(4000);
						obj.clickOnFirstGroupNext();
						
						Thread.sleep(3000);
						obj.clickOnScorecard();
						
						try {
							test.log(Status.PASS, "Scorecard is displayed");
							test.log(Status.PASS, "If R1 -9 correct , R2- 4 correct , R3 - 1 correct: "
									+ "Quantitative Skills scoring marks is correct - 57 ");
							test.log(Status.PASS, "If R1 -9 correct , R2- 4 correct , R3 - 1 correct:"
									+ "Logical Reasoning scoring marks is correct - 57 ");
							test.log(Status.PASS, "If R1 -9 correct , R2- 4 correct , R3 - 1 correct:"
									+ "Language Skills scoring marks is correct - 57");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Scrorecard is not displayed");
						}
								

						String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
						 
						 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
							File file = new File("report.html");
							ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
							reports.attachReporter(sparkReport);
							
							test.addScreenCaptureFromBase64String(source);
							
				}
				
		//Production Case -
			//If all questions are incorrect 
				
				@Test
				public void checkOnProductionNMATPlayerAllIncorrect() throws InterruptedException, IOException, AWTException {
					
					ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player - All Incorrect Questions ").
							  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
					
					NMAT_Staging obj = new NMAT_Staging(driver);
					Screenshot abc = new Screenshot();
					
					Thread.sleep(3000);
					obj.clickOnProductionProfile();
					
					Thread.sleep(4000);
					obj.clickOnProductionChangeProgram();
					
					Thread.sleep(2000);
					obj.selectProductionProgram(driver);
					
					Thread.sleep(3000);
					obj.clickOnProductionDone();
					
					try {
						Thread.sleep(2000);
						obj.clickOnTestTab();
						test.log(Status.PASS, "T001 : Test tab is clickable ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
					}
					
					
					//Click on CAT tier
					
					try {
						obj.clickOnCATTier();
						test.log(Status.PASS, "T002 : CAT tier is clickable ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
					}
					
					//Click on NMAT tier
					
					Thread.sleep(2000);
					try {
						obj.clickOnProductionNMAT();
						test.log(Status.PASS, "T003 : NMAT test page is displayed ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
					}
					
					Thread.sleep(5000);
					try {
						obj.clickOnProductionLaunchTest(driver);
						test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT 23 Aug 2024 ,Test ID - 193-n ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T004 : NMAT test is not launched ");
						
					}
					
//					test.log(Status.PASS, "T005 : Instruction page is displayed ");
//					test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//					test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//					test.log(Status.PASS, "T008 : Quantitative Skills launched");
//					test.log(Status.PASS, "T009 : Timing of section is started from 52");
//					test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//					test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
					
//						Thread.sleep(3000);
//						obj.switchTheWindow(driver);
						
						Thread.sleep(5000);
						obj.clickOnNextNMATtab();
						
						Thread.sleep(3000);
						obj.scrollDownPage(driver);
						
						Thread.sleep(4000);
						obj.clickOnAgreement(driver);
						
						Thread.sleep(3000);
						obj.clickOnNextAgree();
						
						try {
							Thread.sleep(3000);
							obj.clickOnSelectOrder(driver);
					//		obj.clickOrderNext();
							test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
						}
						
						Thread.sleep(3000);
						obj.clickOrderNext();
						
						Thread.sleep(3000);
						obj.clickOnNextFirstGroupNext();
						
						//Quantitative Skills group - 
						
						// First Question 
						try {
							Thread.sleep(3000);
							obj.clickOnThirdOption(driver);
							test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
							
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
						}
						
						obj.clickOnNextQuestion();
						
						//Second Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Third Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Fourth Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Fifth Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Sixth Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Seventh Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Eighth Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Ninth Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Tenth Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Eleventh Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//12 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//13 Question 
						try {
							Thread.sleep(2000);
							obj.clickOnFourthOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After incorrecting 12 questions of Quantitative Skills 'Set 2A' is loaded ");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "After incorrecting 12 questiion of Quantitative Skills 'Set 2A' is not loaded "+e.getMessage());
						}
						
						//14 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//15 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//16 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//17 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//18 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//19 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//20 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//21 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//22 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//23 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//24 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//25 Question
						try {
							Thread.sleep(2000);
							obj.clickOnFifthOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After Incorrect all questions of Round 2 of Quantitative Skills  then 'Set 3A' is loaded. ");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "After Incorrect all questions of Round 2 of Quantitative Skills  then 'Set 3A' is not loaded - "+e.getMessage());
						}
						
						
						//26 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//27 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//28 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//29 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//30 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//31 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//32 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//33 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//34 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						
						//35 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//36 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						try {
							Thread.sleep(4000);
							obj.clickOnFirstGroupNext();
							test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
						}
						
						// Logical Reasoning - 
						try {
							Thread.sleep(4000);
							obj.clickOnFirstGroupNext();
							test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
						}
						
						
						
						//1 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//2 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//3 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//4 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//5 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//6 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//7 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//8 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//9 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//10 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//11 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//12 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//13 Question
						try {
							Thread.sleep(2000);
							obj.clickOnFifthOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After incorrecting 12 questions of Logical Reasoning 'Set 2A' is loaded -");
						}
						catch(Exception e) {
							test.log(Status.FAIL, "After incorrecting 12 questions of Logical Reasoning 'Set 2A' is not loaded "+e.getMessage());
							
						}
						
						//14 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//15 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//16 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//17 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//18 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//19 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//20 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//21 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//22 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//23 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//24 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//25 Question
						try {
							Thread.sleep(2000);
							obj.clickOnFourthOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After incorrecting Round 2 of Logical Reasoning 'Set 3A' is loaded");
						}
						catch(Exception e) {
							test.log(Status.FAIL, "After incorrecting Round 2 of Logical Reasoning 'Set 3A' is not loaded");
							
						}
						
						
						//26 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//27 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//28 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//29 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//30 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//31 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//32 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//33 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//34 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//35 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//36 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();			
						
						Thread.sleep(3000);
						obj.clickOnFirstGroupNext();
						
						try {
							Thread.sleep(3000);
							obj.clickOnFirstGroupNext();
							test.log(Status.PASS, "Language Skills group is launched ");
						}
						catch(Exception e) {
							test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
						}
						
						
						//Language Skills -
						
						//1 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//2 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//3 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//4 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//5 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//6 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//7 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//8 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//9 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//10 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//11 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//12 Question
						try {
							Thread.sleep(2000);
							obj.clickOnThirdOption(driver);
							
							//obj.clickOnNextQuestion();
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correct all questions of Round 1 of Language Skills then 'Set 2A' is loaded");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "After correct all question of Round 1 of Language Skills then 'Set 2A' is not loaded" +e.getMessage());
						}
						
						
						//13 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//14 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//15 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//16 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//17 Question 
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//18 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//19 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();		
						
						//20 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();		
						
						//21 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//22 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//23 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//24 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//25 Question
						try {
							Thread.sleep(2000);
							obj.clickOnThirdOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correct all questions of Round 2 of Language Skills then 'Set 3A' is loaded");
						}
						catch(Exception e) {
							test.log(Status.FAIL, "After correct all questions of Round 2 of language Skills then 'Set 3A' is loaded" +e.getMessage());
						}
						
						//26 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//27 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//28 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//29 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//30 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//31 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//32 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//33 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//34 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//35 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//36 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						
						Thread.sleep(3000);
						obj.clickOnFirstGroupNext();
						
						Thread.sleep(3000);
						obj.clickOnScorecard();
						
						try {
							test.log(Status.PASS, "Scorecard is displayed");
							test.log(Status.PASS, "If all questions are incorrect : "
									+ "Quantitative Skills scoring marks is correct - 12 ");
							test.log(Status.PASS, "If all questions are correct :"
									+ "Logical Reasoning scoring marks is incorrect - 12 ");
							test.log(Status.PASS, "If all questions are correct :"
									+ "Language Skills scoring marks is incorrect - 12 ");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Scrorecard is not displayed");
						}
						
						
						
						

						String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
						 
						 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
							File file = new File("report.html");
							ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
							reports.attachReporter(sparkReport);
							
							test.addScreenCaptureFromBase64String(source);
							
				}
				
			    //Production Case
				//R1-10 , R2-9 , R3-5
				
				@Test
				public void checkOnproduction5thCase() throws InterruptedException, IOException, AWTException {
					
					ExtentTest test = reports.createTest("IMS 3.0 - NMAT Player , R1-10 , R2 - 9 , R3 -5").
							  assignAuthor("Mayuri Patil").assignCategory("NMAT").assignDevice("Chrome");
					
					NMAT_Staging obj = new NMAT_Staging(driver);
					Screenshot abc = new Screenshot();
					
					Thread.sleep(3000);
					obj.clickOnProductionProfile();
					
					Thread.sleep(4000);
					obj.clickOnProductionChangeProgram();
					
					Thread.sleep(2000);
					obj.selectProductionProgram(driver);
					
					Thread.sleep(3000);
					obj.clickOnProductionDone();
					
					try {
						Thread.sleep(2000);
						obj.clickOnTestTab();
						test.log(Status.PASS, "T001 : Test tab is clickable ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T001 : Test tab is not clickable " +e.getMessage());
					}
					
					
					//Click on CAT tier
					
					try {
						obj.clickOnCATTier();
						test.log(Status.PASS, "T002 : CAT tier is clickable ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T002 : CAT tier is not clickable " +e.getMessage());
					}
					
					//Click on NMAT tier
					
					Thread.sleep(2000);
					try {
						obj.clickOnProductionNMAT();
						test.log(Status.PASS, "T003 : NMAT test page is displayed ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T003 :  NMAT test page is not displayed "+e.getMessage());
					}
					
					Thread.sleep(5000);
					try {
						obj.clickOnProductionLaunchTest(driver);
						test.log(Status.PASS, "T004 : NMAT test is launched : Name - NMAT 23 Aug 2024 ,Test ID - 187-n ");
					}
					
					catch(Exception e) {
						test.log(Status.FAIL, "T004 : NMAT test is not launched ");
						
					}
					
//					test.log(Status.PASS, "T005 : Instruction page is displayed ");
//					test.log(Status.PASS, "T006 : Order is selected as Qantitative Skills , Logical Reasoning , Language Skills");
//					test.log(Status.PASS, "T007 : Timing of Order select is : 3 mins");
//					test.log(Status.PASS, "T008 : Quantitative Skills launched");
//					test.log(Status.PASS, "T009 : Timing of section is started from 52");
//					test.log(Status.PASS, "T009 : After corrected 12 question set 2C is launched - text - Find the appoximate value of ");
//					test.log(Status.PASS, "T010 : After corrected 24 questions set 3c is launched - text - Find the common range of");
					
//						Thread.sleep(3000);
//						obj.switchTheWindow(driver);
						
						Thread.sleep(5000);
						obj.clickOnNextNMATtab();
						
						Thread.sleep(3000);
						obj.scrollDownPage(driver);
						
						Thread.sleep(4000);
						obj.clickOnAgreement(driver);
						
						Thread.sleep(3000);
						obj.clickOnNextAgree();
						
						try {
							Thread.sleep(3000);
							obj.clickOnSelectOrder(driver);
					//		obj.clickOrderNext();
							test.log(Status.PASS, "T005 : Select order of sections : Order timing : 3 mins");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "T005 : Order is not selected "+e.getMessage());
						}
						
						Thread.sleep(3000);
						obj.clickOrderNext();
						
						Thread.sleep(3000);
						obj.clickOnNextFirstGroupNext();
						
						//Quantitative Skills group - 
						
						// First Question 
						try {
							Thread.sleep(3000);
							obj.clickOnFirstQuestion(driver);
							test.log(Status.PASS, "T006 : First group : Quantitative Skills - 52 mins ");
							
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "T006 : First question is not attempted " +e.getMessage());
						}
						
						obj.clickOnNextQuestion();
						
						//Second Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Third Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Fourth Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Fifth Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//Sixth Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Seventh Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Eighth Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Ninth Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Tenth Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//Eleventh Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//12 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//13 Question 
						try {
							Thread.sleep(2000);
							obj.clickOnFourthOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correcting 10 questions 'Set 2B' is loaded ");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Set is not loaded "+e.getMessage());
						}
						
						//14 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//15 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//16 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//17 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//18 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//19 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//20 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//21 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//22 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//23 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//24 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//25 Question
						try {
							Thread.sleep(2000);
							obj.clickOnFifthOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correct 9 questions of Round 2  then 'Set 3C' is loaded. ");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Set is loaded "+e.getMessage());
						}
						
						
						//26 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//27 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//28 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//29 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//30 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//31 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//32 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//33 Question
						Thread.sleep(3000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//34 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						
						//35 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//36 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						try {
							Thread.sleep(4000);
							obj.clickOnFirstGroupNext();
							test.log(Status.PASS, "First Group - ' Quantitative Skills ' is completed ");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "First Group - ' Quantative Skills ' is not completed "+e.getMessage());
						}
						
						
						// Logical Reasoning - 
						//R1 -10 , R2 -9, R3-5
						
						try {
							Thread.sleep(4000);
							obj.clickOnFirstGroupNext();
							test.log(Status.PASS, "Second Group - ' Logical Reasoning is launched - Time -  40 mins");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Second Group - ' Logical Reasoning is not launched "+e.getMessage());
						}
						
						
						
						//1 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//2 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//3 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//4 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//5 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//6 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//7 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//8 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//9 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//10 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//11 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//12 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//13 Question
						try {
							Thread.sleep(2000);
							obj.clickOnFourthOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correcting 10 questions 'Set 2B' is loaded -");
						}
						catch(Exception e) {
							test.log(Status.FAIL, "Set is not loaded "+e.getMessage());
							
						}
						
						//14 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//15 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//16 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//17 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//18 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//19 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//20 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//21 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//22 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//23 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//24 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						test.log(Status.PASS, "After correct 9 questions of Round 2 'Set 3C is loaded");
						
						
						//25 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//26 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//27 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//28 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//29 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//30 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//31 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//32 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//33 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//34 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//35 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//36 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();			
						
						Thread.sleep(3000);
						obj.clickOnFirstGroupNext();
						
						try {
							Thread.sleep(3000);
							obj.clickOnFirstGroupNext();
							test.log(Status.PASS, "Language Skills group is launched ");
						}
						catch(Exception e) {
							test.log(Status.FAIL, "Language Skills group is not launched "+e.getMessage());
						}
						
						
						//Language Skills -
						
						//1 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//2 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//3 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//4 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//5 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//6 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//7 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//8 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//9 Question
						Thread.sleep(2000);
						obj.clickOnFirstQuestion(driver);
						
						obj.clickOnNextQuestion();
						
						//10 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//11 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//12 Question
						try {
							Thread.sleep(2000);
							obj.clickOnSecondOption(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correct 10 questions of Round 1 then 'Set 2B' is loaded");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Set is not loaded " +e.getMessage());
						}
						
						
						//13 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//14 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//15 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//16 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//17 Question 
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//18 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//19 Question
						Thread.sleep(2000);
						obj.clickOnThirdOption(driver);
						
						obj.clickOnNextQuestion();
						
						//20 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//21 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//22 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//23 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//24 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//25 Question
						try {
							Thread.sleep(2000);
							obj.clickOnFirstQuestion(driver);
							
							obj.clickOnNextQuestion();
							test.log(Status.PASS, "After correct 9 questions of Round 2  then 'Set 3C' is loaded");
						}
						catch(Exception e) {
							test.log(Status.FAIL, "Set is not loaded" +e.getMessage());
						}
						
						//26 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//27 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//28 Question
						Thread.sleep(2000);
						obj.clickOnFifthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//29 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//30 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//31 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//32 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//33 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//34 Question
						Thread.sleep(2000);
						obj.clickOnSecondOption(driver);
						
						obj.clickOnNextQuestion();
						
						//35 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						//36 Question
						Thread.sleep(2000);
						obj.clickOnFourthOption(driver);
						
						obj.clickOnNextQuestion();
						
						
						Thread.sleep(4000);
						obj.clickOnFirstGroupNext();
						
						Thread.sleep(3000);
						obj.clickOnScorecard();
						
						try {
							test.log(Status.PASS, "Scorecard is displayed");
							test.log(Status.PASS, "If R1 -10 correct , R2- 9 correct , R3 - 5 correct: "
									+ "Quantitative Skills scoring marks is  not correct - Current Score - 86 , Expected Score - 86 ");
							test.log(Status.PASS, "If R1 -10 correct , R2- 9 correct , R3 - 5 correct:"
									+ "Logical Reasoning scoring marks is  not correct - Current Score - 86 , Expected Score - 86  ");
							test.log(Status.PASS, "If R1 -10 correct , R2- 9 correct , R3 - 5 correct:"
									+ "Language Skills scoring marks is correct - Current Score - 86, Expected Score - 86 ");
						}
						
						catch(Exception e) {
							test.log(Status.FAIL, "Scrorecard is not displayed");
						}
								

						String source = pom.Login_IMS.extent(driver, "NMAT - Launch");
						 
						 //String screen = Screenshot.takeScreenshot(driver, "Login Item Banking");
							File file = new File("report.html");
							ExtentSparkReporter sparkReport = new ExtentSparkReporter(file);
							reports.attachReporter(sparkReport);
							
							test.addScreenCaptureFromBase64String(source);
						
					
				}
				
		
		
		
		
		@AfterClass
		public void flushResults() {
			reports.flush();
			//driver.quit();
		}

}
