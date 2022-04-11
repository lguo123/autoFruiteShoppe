package test.java.com.qa.fullStory.tc;

import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;
import test.java.com.qa.fullStory.po.Checkout;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Test01 {

	ChromeDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void fS_test1() throws InterruptedException {

		int waitTime = 2000;

		// launch the site
		driver.get("https://fruitshoppe.firebaseapp.com/");
		analyzeLog();
		Thread.sleep(waitTime);

		// navigate to Market page
		driver.findElement(By.partialLinkText("Market")).click();
		analyzeLog();
		Thread.sleep(waitTime);

		// pick products
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div[1]/div/div[3]/div/div[2]/a")).click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[2]/div[2]/div/div[3]/div/div[2]/a")).click();
		analyzeLog();
		Thread.sleep(waitTime);

		// go to Cart
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/a[3]/span[1]")).click();
		analyzeLog();
		Thread.sleep(waitTime);

		// go to Checkout page
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[3]/a")).click();
		analyzeLog();
		Thread.sleep(waitTime);

		// input customer data
		Checkout.inputCustomerData(driver);
		analyzeLog();
		Thread.sleep(waitTime);

		// verify order was placed successfully
		if (driver.getPageSource().contains("Order received!")) {
			System.out.println("Order Successfully placed.");
		} else {
			System.out.println("The order was not placed....");
		}

	}

	public void analyzeLog() {

		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		List<LogEntry> logEntryList = logEntries.getAll();

		for (LogEntry le : logEntryList) {
			System.out.println(le.getMessage());
		}
		
		// If the logs are retrieved correct, here is to parse and assert.
		
	}

}
