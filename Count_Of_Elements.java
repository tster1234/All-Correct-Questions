package zzusable;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Count_Of_Elements {
	
	@FindBy(xpath = "//p[@class='font-normal text-xl py-4']")private List<WebElement> count;
	
	public void countBenchmarkingTest() {
		int elementCount = count.size();
		
		System.out.println("Total number of elements found: " + elementCount);
	}

}
