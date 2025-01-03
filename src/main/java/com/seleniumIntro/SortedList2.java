package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;

public class SortedList2 {

    private WebDriver driver;
    private String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
        driver.get(url);

        // Select Number items on a table
        WebElement dropdown = driver.findElement(By.id("page-menu"));
        Select select = new Select(dropdown);
        select.selectByValue("5");
    }

    @Test
    public void testAscendingSort() {
        WebElement columnHeader = driver.findElement(By.xpath("//thead/tr/th[1]"));
        columnHeader.click();
        List<String> listAfterSortAscending = getListItems(driver);

        // Expected sorted list
        List<String> expectedSortedListAscending = listAfterSortAscending
                .stream()
                .sorted()
                .toList();

        // Assertion
        Assert.assertEquals(listAfterSortAscending, expectedSortedListAscending,
                "Test table sorting Ascending order has failed.");
        System.out.println("Ascending sort test passed.");
    }

    @Test
    public void testDescendingSort() {
        WebElement columnHeader = driver.findElement(By.xpath("//thead/tr/th[1]"));
        columnHeader.click();  // Sort Descending
        columnHeader.click();

        List<String> listAfterSortDescending = getListItems(driver);

        // Expected sorted list
        List<String> expectedSortedListDescending = listAfterSortDescending
                .stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        // Assertion
        Assert.assertEquals(listAfterSortDescending, expectedSortedListDescending,
                "Test table sorting Descending order has failed.");
        System.out.println("Descending sort test passed.");
    }

    private List<String> getListItems(WebDriver driver) {
        return driver.findElements(By.xpath("//tbody/tr/td[1]"))
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

