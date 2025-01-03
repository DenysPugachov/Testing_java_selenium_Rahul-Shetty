package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SortedList {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);

        // Select Number items on a table
        WebElement dropdown = driver.findElement(By.id("page-menu"));
        Select select = new Select(dropdown);
        select.selectByValue("5");

        WebElement columnHeader = driver.findElement(By.xpath("//thead/tr/th[1]"));

        // Sort items in column A->Z
//        columnHeader.click();
        List<String> listAfterSortAscending = getListItems(driver);

        // Sort items in column Z->A
        columnHeader.click();
        columnHeader.click();
        List<String> listAfterSortDescending = getListItems(driver);

         List<String> expectedSortedListAscending = listAfterSortAscending
                .stream()
                .sorted()
                .toList();

        List<String> expectedSortedListDescending = listAfterSortDescending
                .stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        // TESTS
        testDescendingSort(expectedSortedListDescending, listAfterSortDescending);
        testAscendingSort(expectedSortedListAscending, listAfterSortAscending);

        driver.quit();
    }

    private static void printList(String nameOfList, List<String> list) {
        System.out.println(nameOfList + ": " + list);
    }

    private static List<String> getListItems(WebDriver driver) {
        return driver.findElements(By.xpath("//tbody/tr/td[1]"))
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    @Test
    public static void testAscendingSort(List<String> expectedSortedListAscending, List<String> listAfterSortAscending) {
        Assert.assertEquals(expectedSortedListAscending, listAfterSortAscending, "Test table sorting Ascending order has fail.");
        System.out.println("Ascending sort test pass");
    }

    @Test
    public static void testDescendingSort(List<String> expectedSortedListDescending, List<String> listAfterSortDescending) {
        Assert.assertEquals(expectedSortedListDescending, listAfterSortDescending, "Test table sorting Descending order has fail.");
        System.out.println("Descending sort test pass");
    }
}
