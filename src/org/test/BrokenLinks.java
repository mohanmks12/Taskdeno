package org.test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class BrokenLinks {
	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\mohan\\eclipse-workspace\\Screenshot123\\drivers\\msedgedriver.exe");

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.facebook.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// get link count
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linkcount = links.size();
		System.out.println("total link count========" + linkcount);

		// get all links
		for (int i = 0; i < links.size(); i++) {
			WebElement eachweb = links.get(i);
			String allLink = eachweb.getAttribute("href");
			System.out.println(allLink);

		}
		// verify the link good or broken
		System.out.println("========link broken====");
		for (int i = 0; i < links.size(); i++) {
			WebElement eachweb = links.get(i);
			String allLink = eachweb.getAttribute("href");

			URL url = new URL(allLink);
			URLConnection urlcon = url.openConnection();

			HttpURLConnection hp = (HttpURLConnection) urlcon;

			int responseCode = hp.getResponseCode();
			if (responseCode < 400) {
				System.out.println(allLink + "==" + responseCode);
			}

		}

		// get image count
		List<WebElement> image = driver.findElements(By.tagName("img"));
		int imagecount = image.size();
		System.out.println("imagecount========" + imagecount);

		// get all image
		for (int i = 0; i < image.size(); i++) {
			WebElement eachimg = image.get(i);
			String allimage = eachimg.getAttribute("src");
			System.out.println(allimage);

		}

		// verify the image good or broken
		System.out.println("========image broken====");
		for (int i = 0; i< image.size(); i++) {
			WebElement eachimg = image.get(i);
			String allimage = eachimg.getAttribute("src");

			URL url2 = new URL(allimage);
			URLConnection imgcon = url2.openConnection();

			HttpURLConnection hp2 = (HttpURLConnection) imgcon;

			int responseCode2 = hp2.getResponseCode();
			if (responseCode2 < 400) {
				System.out.println(allimage + "==" + responseCode2);	
			}
			
		}
		System.out.println("====done all===========");
	}
}
// 2200 is HTTP response status codes not broken is good
// 400 and above is HTTP response status codes broken