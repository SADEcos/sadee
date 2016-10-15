package com.unicamp.mc437.AutomationProject;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;

public class GoogleSearchScenario {

	private WebDriver driver;

	@Before
	public void setUp() throws IOException{
		File classpathRoot = new File(System.getProperty("user.dir"));
		File chromedriver = new File(classpathRoot, "driver/chromedriver");
		System.setProperty("webdriver.chrome.driver", chromedriver.getAbsolutePath());
		driver = new ChromeDriver();
	}
	
	@After
	public void tearDown(){
		driver.close();
	}
	
	@Given("^the page is open \"([^\"]*)\"$")
	public void the_page_is_open(String page) throws Throwable {
		driver.get(page);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void I_search_for(String search) throws Throwable {
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(search);
		element.submit();
	}

	@Then("^a browser title should contains \"([^\"]*)\"$")
	public void a_browser_title_should_contains(String text) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.titleContains(text));
		assertThat(driver.getTitle()).contains(text);
	}
}
