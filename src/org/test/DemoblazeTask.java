package org.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;

public class DemoblazeTask {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"\\Users\\mohan\\eclipse-workspace\\SeleniumAll\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.demoblaze.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement signin = driver.findElement(By.id("signin2"));
		signin.click();
		WebElement signusername = driver.findElement(By.id("sign-username"));
		signusername.sendKeys("mohanmks.dl@gmail.com");
		WebElement signpassword = driver.findElement(By.id("sign-password"));
		signpassword.sendKeys("Mohan274644@");
		WebElement signup = driver.findElement(By.xpath("//button[text()='Sign up']"));
		signup.click();
		Thread.sleep(3000);
		Alert al = driver.switchTo().alert();
		String text = al.getText();
		System.out.println(text);
		al.accept();

		WebElement close1 = driver.findElement(By.xpath("(//button[text()='Close'])[2]"));
		close1.click();

		WebElement sign1 = driver.findElement(By.id("login2"));
		sign1.click();
		WebElement loginusername = driver.findElement(By.id("loginusername"));
		loginusername.sendKeys("mohanmks.dl@gmail.com");
		WebElement loginpassword = driver.findElement(By.id("loginpassword"));
		loginpassword.sendKeys("Mohan274644@");

		WebElement ButtonLogin = driver.findElement(By.xpath("//button[text()='Log in']"));
		ButtonLogin.click();

		// WebElement nameget = driver.findElement(By.xpath("//a[@id='nameofuser']"));
		// String a = nameget.getText();

		// String n = nameget.getAttribute("innerText");

		// System.out.println(a);
		List<WebElement> listcat = driver.findElements(By.xpath("//div[@class='list-group']"));

		for (int i = 0; i < listcat.size(); i++) {
			WebElement ge = listcat.get(i);
			String att = ge.getText();
			System.out.println(att);
		}
		//
		// WebElement ph = driver.findElement(By.xpath("//a[text()='Phones']"));
		// ph.click();
		System.out.println("==========phone list========");

		List<WebElement> ph11 = driver.findElements(By.xpath("//h4[@class='card-title']"));
		System.out.println("==only sam and sony==");
		List<String> li = new ArrayList<String>();

		for (WebElement x : ph11) {
			String text2 = x.getText();
			li.add(text2);
			if (text2.contains("Samsung") || text2.contains("Sony")) {
				System.out.println(x.getText());
			}
		}
		System.out.println("==all phone==");
		System.out.println(li);
		Thread.sleep(3000);
		
		System.out.println("==========laptops=============");
		WebElement lap = driver.findElement(By.xpath("//a[text()='Laptops']"));
		lap.click();
		System.out.println("click lap");
		
		
		List<WebElement> ph2 = driver.findElements(
				By.xpath("//a[@href='prod.html?idp_=11']//following::h4[@class='card-title']//a[@class='hrefch']"));
		List<String> ll = new ArrayList<String>();

		for (WebElement x1 : ph2) {
			String tx = x1.getText();
			ll.add(tx);
			if (tx.contains("MacBook")) {
				System.out.println(x1.getText());
			}
		}
		System.out.println(ll);
		
		
		System.out.println("==========monitors======= ");

		WebElement tv = driver.findElement(By.xpath("//a[text()='Monitors']"));
		tv.click();
		List<WebElement> tv1 = driver.findElements(
				By.xpath("//a[@href='prod.html?idp_=10']//following::h4[@class='card-title']//a[@class='hrefch']"));

		for (WebElement x2 : tv1) {
			System.out.println(x2.getText());
		}

		System.out.println("=========all done===========");

	}
}
