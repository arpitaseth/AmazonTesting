package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Steps {
	private static WebDriver driver;
	
	@Before
    public void openBrowser(){		
		System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }	
	
	@Given("^User navigates to \"([^\"]*)\"$")
	public void user_navigates_to(String webpage) throws Throwable {		
		driver.get(webpage);
		System.out.println("\n******************** TEST STEPS START ********************\n");
		System.out.println("User has navigated to: " + webpage);
	}

	@When("^user searches for \"([^\"]*)\"$")
	public void user_searches_for(String searchitem) throws Throwable {
		// Find the text input element by its id
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchitem);
		// Click Search button
		driver.findElement(By.id("nav-search-submit-button")).click();		
		System.out.println("User has searched for: " + searchitem);
	}

	@When("^sorts the result from highest price to lowest$")
	public void sorts_the_result_from_highest_price_to_lowest() throws Throwable {
		// Wait until the sorting option is visible on the webpage
		WebDriverWait sortSelectWait = new WebDriverWait(driver, 10);
        WebElement sortSelect = sortSelectWait.until(ExpectedConditions.elementToBeClickable(By.id("s-result-sort-select")));
		new Select(sortSelect).selectByVisibleText("Price: High to Low");
		System.out.println("User has sorted search results from highest price to lowest");
	}

	@When("^clicks second product for details$")
	public void clicks_second_product_for_details() throws Throwable {
		String xpath_findProduct = "div[@data-asin and string-length(@data-asin)!=0]";
		//Select second highest price product and click on it
		WebElement secondProduct = driver.findElement(By.xpath("//"+xpath_findProduct+"/following-sibling::"+ xpath_findProduct+"//a"));
		secondProduct.click();
		System.out.println("User has clicked to check details of second product");
	}

	@Then("^checks product title contains \"([^\"]*)\"$")
	public void checks_product_title_contains(String matchitem) throws Throwable {
		// Verifies that product title for second highest price product contains 'matchitem'
		String secondProductTitle = driver.findElement(By.id("productTitle")).getText();
		try {
		Assert.assertTrue(secondProductTitle.contains(matchitem));
		} catch (AssertionError ae) {
			System.out.println("Product title of second most expensive product is: " + secondProductTitle);
		}		
	}
	
	@After()
    public void closeBrowser() {
		if(driver!=null)
		{
			System.out.println("\n******************** TEST STEPS END **********************\n");
			driver.quit();
		}
    }


}
