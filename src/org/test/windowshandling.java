package org.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import graphql.org.antlr.v4.runtime.tree.xpath.XPath;

public class windowshandling {
	public static void main(String[] args) throws IOException {
				System.setProperty("webdriver.edge.driver",
						"C:\\Users\\mohan\\eclipse-workspace\\Screenshot123\\drivers\\msedgedriver.exe");

			WebDriver driver = new EdgeDriver();
			driver.get("https://www.facebook.com/");
					
			driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

//		//windows handle topic
//		WebElement btncl = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
//		btncl.click();
		
		//find web element and following -sibling
		
		WebElement searchbtn = driver.findElement(By.xpath("//a[text()='Create New Account']"));
		searchbtn.click();
//		searchbtn.sendKeys("redmi", Keys.ENTER);
		
		List<WebElement> redmi1 = driver.findElements(By.xpath("//select[@id='month']"));
		for(WebElement x1:redmi1) {
			System.out.println(x1.getText());
		}
		
		List<WebElement> redmi2 = driver.findElements(By.tagName("li"));
		for(WebElement x2:redmi2) {
			System.out.println(x2.getText());
		}
		
		List<WebElement> redmi3 = driver.findElements(By.xpath("//select[@id='year']"));
		for(WebElement x3:redmi3) {
			System.out.println(x3.getText());
		}
		System.out.println("========take all web element after current element=====");
		List<WebElement> redmi4 = driver.findElements(By.xpath("//select[@id='month']//following-sibling::option"));
		for(WebElement x4:redmi4) {
			System.out.println(x4.getText());
		}
		System.out.println("========take all before web element=====");
		List<WebElement> redmi5 = driver.findElements(By.xpath("//option[text()='Apr']//preceding-sibling::option"));
		for(WebElement x5:redmi5) {
			System.out.println(x5.getText());
		}
		
		System.out.println("========before all web element only family=====");
		List<WebElement> redmi6 = driver.findElements(By.xpath("//option[text()='Oct']//preceding::option"));
		for(WebElement x6:redmi6) {
			System.out.println(x6.getText());
		}
		System.out.println("========parent/child  web element=====");
		List<WebElement> redmi7 = driver.findElements(By.xpath("//option[text()='Feb']//parent::select//following::select[@id='year']//child::option[@value='2020']"));
		for(WebElement x7:redmi7) {
			System.out.println(x7.getText());
		}
		System.out.println("========grandparent/grandchild  web element=====");
		List<WebElement> redmi8 = driver.findElements(By.xpath("//option[text()='Feb']//parent::select//following::select[@id='year']//child::option[@value='2020']//ancestor::span[2]//descendant::select"));
		for(WebElement x8:redmi8) {
			System.out.println(x8.getText());
		}
		
		
		
		
		//option[text()='Feb']//preceding::option
		
//		redmi.click();
		
		//parent id
		String parentid = driver.getWindowHandle();
	    System.out.println(parentid);
	    
	    //all id
	    Set<String> allid = driver.getWindowHandles();
	    System.out.println(allid);
	    
	    //set into list
	     List<String> li =new ArrayList<String>();
	    li.addAll(allid);
	    driver.switchTo().window(li.get(1));
	    
	    WebElement pincode = driver.findElement(By.id("pincodeInputId"));
	    pincode.sendKeys("637215");
	    
	    
	}
}
