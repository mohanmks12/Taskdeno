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

public class NavigateCommands {

	public static void main(String[] args) throws IOException, InterruptedException {
					System.setProperty("webdriver.edge.driver",
							"C:\\Users\\mohan\\eclipse-workspace\\Screenshot123\\drivers\\msedgedriver.exe");

				WebDriver driver = new EdgeDriver();
				driver.get("https://www.flipkart.com/");
						
				driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			//back
			driver.navigate().back();
			Thread.sleep(3000);
			
			//forward
			driver.navigate().forward();
			Thread.sleep(3000);
			
			//refresh
			driver.navigate().refresh();
			Thread.sleep(3000);
			
			//isDisplayed=======>email web element =======>true/false
			//isenabled========>before create btn========>true/false
			//isSelected====>after click radio btn====true/false
			
}}
