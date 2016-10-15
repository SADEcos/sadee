package com.unicamp.mc437.AutomationProject;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class GoogleTest 
{

	public static void main(String[] args) {
		File classpathRoot = new File(System.getProperty("user.dir"));
		File chromedriver = new File(classpathRoot, "driver/chromedriver");
		System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cucumber");
		element.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains("Cucumber"));
		
		if (driver.getTitle().contains("Cucumber")) {
			System.out.println("Success!");
		} else {
			System.out.println("Fail!");
		}
		
		driver.close();
	}

}