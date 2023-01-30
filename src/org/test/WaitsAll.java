package org.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.implementation.bytecode.Duplication;

public class WaitsAll {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.edge.driver",
			"C:\\Users\\mohan\\eclipse-workspace\\SeleniumAll\\drivers\\msedgedriver.exe");

	WebDriver driver = new EdgeDriver();
	driver.get("https://www.facebook.com/");

	driver.manage().window().maximize();
	//1.static wait
	Thread.sleep(3000);
    //2. dynamic wait
    //a.implicit Wait
//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	//	b.Explicit wait
//	1. Web Driver wait
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
     alert.accept();

	
//	2. Fluent wait
	FluentWait<WebDriver> f = new FluentWait<WebDriver>(driver)
	.withTimeout(Duration.ofSeconds(50))
	.pollingEvery(Duration.ofSeconds(5))
	.ignoring(Throwable.class);
	
	//alert
	Alert fluent = f.until(ExpectedConditions.alertIsPresent());
	fluent.accept();
}
}
