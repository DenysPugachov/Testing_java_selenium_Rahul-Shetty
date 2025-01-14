package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

public class SeleniumSkeletonTest {

    private WebDriver driver;

    /**
     * Runs once before all tests in the class.
     * Use this to set up any global configurations, such as system properties.
     */
    @BeforeClass
    public void setupClass() {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Set your chromedriver path
    }

    /**
     * Runs before each test method.
     * Initializes the WebDriver, configures browser options, and sets timeouts.
     */
    @BeforeMethod
    public void setupMethod() {
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    /**
     * Contains the actual test logic.
     * Use driver to interact with web elements and perform assertions with Assert.
     */
    @Test
    public void testExample() {
        // Navigate to the target website
        driver.get("https://google.com");

        // Example test logic
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        searchBox.submit();

        // Validate search results
        List<WebElement> results = driver.findElements(By.cssSelector(".result-item"));
        Assert.assertTrue(results.size() > 0, "No search results found!");

        // Example assertion
        String firstResultText = results.get(0).getText();
        Assert.assertTrue(firstResultText.contains("Selenium"), "First result does not contain 'Selenium'");
    }

    /**
     * Runs after each test method.
     * Ensures the browser is closed after each test to free resources.
     */
    @AfterMethod
    public void tearDownMethod() {
        if (driver != null) {
            driver.quit();
        }
    }

    /**
     * Runs once after all tests in the class.
     * Use this for additional cleanup or reporting.
     */
    @AfterClass
    public void tearDownClass() {
        // Additional cleanup if needed
        System.out.println("Test execution completed.");
    }
}
