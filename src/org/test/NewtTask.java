package org.test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class NewtTask {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"\\Users\\mohan\\eclipse-workspace\\SeleniumAll\\drivers\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://amesqa.amnet-systems.com/AmES_v2.3.1/login");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	

WebElement txtuser = driver.findElement(By.id("txtUser"));
txtuser.sendKeys("AMQ1708");

WebElement txtPass = driver.findElement(By.id("txtPass"));
txtPass.sendKeys("QA@123");

WebElement login = driver.findElement(By.id("submit"));
login.click();

WebElement jobCard = driver.findElement(By.id("jobCardBannerLink_id"));
jobCard.click();

WebElement addnew = driver.findElement(By.id("j_idt314"));
addnew.click();
System.out.println("url lanch");
Thread.sleep(3);
WebElement ebooks = driver.findElement(By.id("jobType"));
//ebooks.click();
Select s = new Select(ebooks);
s.selectByIndex(0);
Thread.sleep(3);

WebElement customer = driver.findElement(By.xpath("//select[@id='dds_3']"));
//customer.click();
Thread.sleep(3);
Select scus=new Select(customer);
scus.selectByVisibleText("QA Customer Interview -US");
Thread.sleep(3);

WebElement project = driver.findElement(By.xpath("//select[@id='dds_6']"));

Select proj=new Select(project);
proj.selectByVisibleText("QA Interview Project");
Thread.sleep(3);


WebElement workflow = driver.findElement(By.xpath("//span[text()='Web Accessibility Testing FL ']"));
workflow.click();

WebElement Category = driver.findElement(By.xpath("//select[@id='dds_21']"));
Select Categ=new Select(Category);
Categ.selectByVisibleText("eBook");
Thread.sleep(3);
WebElement customerr = driver.findElement(By.xpath("//select[@id='dds_10']"));
Select cu=new Select(customerr);
cu.selectByVisibleText("Sathish Babu");
Thread.sleep(3);



WebElement bookid = driver.findElement(By.xpath("//input[@id='ttb_15']"));
bookid.sendKeys("123456");
WebElement booktitle = driver.findElement(By.xpath("//input[@id='ttb_16']"));
booktitle.sendKeys("jobcardtest");

//input[@id='ttb_16']
WebElement eISBN = driver.findElement(By.xpath("//input[@id='nrr_20']"));
eISBN.sendKeys("9783161484100");
WebElement pISBN  = driver.findElement(By.xpath("//input[@id='nrr_19']"));
pISBN.sendKeys("9781566199094");
WebElement submit  = driver.findElement(By.xpath("//input[@type='submit']"));
submit.click();
//input[@type='submit

System.out.println("QA Customer Interview -US ===ok");


//p[@class='CaptionCont SlectBox']dds_21
	}
	

}
