package test.java.com.qa.fullStory.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Checkout {

	public static void  inputCustomerData(WebDriver driver) {
		
		driver.findElement(By.id("billing-firstname")).sendKeys("MyFirstName");
		driver.findElement(By.id("billing-lastname")).sendKeys("MyLastName");
		driver.findElement(By.id("billing-address-1")).sendKeys("123 Abc");
		driver.findElement(By.id("billing-city")).sendKeys("Xyz");
		driver.findElement(By.id("billing-zip")).sendKeys("12345");
		driver.findElement(By.id("shipping-same-billing")).click();
		driver.findElement(By.id("credit_card_number")).sendKeys("1111222233334444");
		Select expireYear = new Select(driver
				.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[3]/form/div[2]/div/div[1]/select[2]")));
		expireYear.selectByVisibleText("2025");
		driver.findElement(By.id("credit_card_cvv")).sendKeys("123");
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[3]/form/div[3]/label")).click();		
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div[3]/form/a")).click();
		
	}
}
