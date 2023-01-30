package org.test;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Screenshot1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\mohan\\eclipse-workspace\\Screenshot123\\drivers\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.flipkart.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		WebElement logclose = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		logclose.click();

		WebElement search = driver.findElement(By.xpath("//input[@title='Search for products, brands and more']"));
		search.sendKeys("iphone");

		WebElement clicksearch = driver.findElement(By.xpath("//button[@type='submit']"));
		clicksearch.click();

		List<WebElement> listiphone = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		List<String> s1 = new ArrayList<String>();

		for (int i = 0; i < listiphone.size(); i++) {
			String totaliphone = listiphone.get(i).getText();
			s1.add(totaliphone);

		}
		System.out.println(s1);

		List<WebElement> price = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		List<String> s2 = new ArrayList<String>();
		for (WebElement x : price) {

			s2.add(x.getText());

		}
		System.out.println(s2);

		int count = 1;
		for (int i = 0; i < price.size(); i++) {

			String allprice = price.get(i).getText();
			String allproduct = listiphone.get(i).getText();
			System.out.println(count + " - " + allproduct + " - " + allprice);
			count++;
		}
		List<String> s3 = new ArrayList<String>();
		for (int i = 0; i < s2.size(); i++) {
			s3.add(s2.get(i).replaceAll("₹", ""));

		}
		System.out.println(s3);

		System.out.println("============================");
		List<String> s4 = new ArrayList<String>();
		for (int i = 0; i < s3.size(); i++) {
			s4.add(s3.get(i).replaceAll(",", ""));

		}
		List<Integer> parint = new ArrayList<Integer>();
		for (String x1 : s4) {
			parint.add(Integer.parseInt(x1));
		}
		System.out.println(parint);

		System.out.println("=====max price========");
		Integer max = Collections.max(parint);
		System.out.println(max);

		System.out.println("=====min price======");
		Integer min = Collections.min(parint);
		System.out.println(min);

		System.out.println("=====accending order price======");
		Collections.sort(parint);
		System.out.println(parint);
		
		System.out.println("=====decending order price======");
		Collections.reverse(parint);
		System.out.println(parint);

		// int t=0;
		// for (int i = 0; i < parint.size(); i++) {
		// for (int j = i+1; j <parint.size(); j++) {
		// if(parint.get(i)>parint.get(j))
		// {
		// t=parint.get(i);
		// parint.set(i, parint.get(j));
		// parint.set(j, t);
		// }
		// }
		// }
		// System.out.println(parint);

		// TakesScreenshot tk =(TakesScreenshot)driver;
		// File src = tk.getScreenshotAs(OutputType.FILE);
		// long time = System.currentTimeMillis();
		// File des =new
		// File("C:\\Users\\mohan\\eclipse-workspace\\Screenshot123\\screenshotfolder\\image"+time+".png");
		// FileUtils.copyFile(src,des);
		// System.out.println("=======done=======");
		// driver.quit();

		System.out.println("=======mapping=======");

		Map<String, Integer> mp = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < s1.size(); i++) {
			mp.put(s1.get(i), parint.get(i));
		}

		for (Entry<String, Integer> x : mp.entrySet()) {
			System.out.println(x);

		}

		System.out.println("=======get one key price in map=======");

		Integer ii = mp.get("APPLE iPhone 13 (Green, 128 GB)");
		System.out.println(ii);

		System.out.println("======removeduplicateproduct========");
		Set<String> removeduplicateproduct = new TreeSet<String>();
		removeduplicateproduct.addAll(s1);
		System.out.print(removeduplicateproduct);

		System.out.println();
		System.out.println("======removeduplicateprice========");
		Set<Integer> removeduplicateprice = new TreeSet<Integer>();
		removeduplicateprice.addAll(parint);
		System.out.print(removeduplicateprice);

	}

}
