package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.Comparator;
import java.util.List;


public class SortedList {
    private static class ConsoleColors {
        public static final String RED = "\033[31m";
        public static final String GREEN = "\033[32m";
        public static final String YELLOW = "\033[33m";
        public static final String BLUE = "\033[34m";
        public static final String RESET = "\033[0m";
    }
    private static final String URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";

    public static void main(String[] args) throws InterruptedException {
        testDesSort(getWebDriver());
        testAscSort(getWebDriver());
    }


    private static WebDriver getWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return new FirefoxDriver(options);
    }

    public static void selectItemsNumber(Integer number, WebDriver driver){
        WebElement dropdown = driver.findElement(By.id("page-menu"));
        Select select = new Select(dropdown);
        select.selectByValue(number.toString());
    }


    public static List<String> getListItems(WebDriver driver) {
        return driver.findElements(By.xpath("//tbody/tr/td[1]"))
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public static void testListsEquals(String testName, List<String> expectedList, List<String> actualList) {
        try {
            Assert.assertEquals(expectedList, actualList, ConsoleColors.RED + testName + " test has fail: " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + testName + " test has passed." + ConsoleColors.RESET);
        } catch (AssertionError err) {
            System.out.println(err.getMessage());
            System.out.println("expect: " + expectedList);
            System.out.println("actual: " + actualList);
        }
    }

    public static void testListsNotEquals(String testName, List<String> expectedList, List<String> actualList) {
        try {
            Assert.assertNotEquals(expectedList, actualList, ConsoleColors.RED + testName + " test has fail: " + ConsoleColors.RESET);
            System.out.println(ConsoleColors.GREEN + testName + " test has passed." + ConsoleColors.RESET);
        } catch (AssertionError err) {
            System.out.println(err.getMessage());
            System.out.println("expect: " + expectedList);
            System.out.println("actual: " + actualList);
        }

    }

    private static void testAscSort(WebDriver driver) {
        driver.get(URL);
        selectItemsNumber(10, driver);
        WebElement columnHeader = driver.findElement(By.xpath("//thead/tr/th[1]"));
        List<String> listBeforeSort = getListItems(driver);
        columnHeader.click(); // sort A-Z
        List<String> listAfterSortAscending = getListItems(driver);
        List<String> listSortedAsc = listAfterSortAscending.stream().sorted().toList();
        testListsEquals("Ascending sort", listAfterSortAscending, listSortedAsc);
        testListsNotEquals("Ascending sort is changing list", listAfterSortAscending, listBeforeSort);
        driver.quit();
    }

    private static void testDesSort(WebDriver driver) {
        driver.get(URL);
        selectItemsNumber(20, driver);
        WebElement columnHeader = driver.findElement(By.xpath("//thead/tr/th[1]"));
        columnHeader.click(); // sort A->Z
        List<String> listBeforeSort = getListItems(driver);
        columnHeader.click(); // sort Z->A
        List<String> listAfterSortDescending = getListItems(driver);
        List<String> expectedListSortedDesc = listAfterSortDescending.stream().sorted(Comparator.reverseOrder()).toList();
        testListsEquals("Descending sort", listAfterSortDescending, expectedListSortedDesc);
        testListsNotEquals("Descending sort is changing list", listAfterSortDescending, listBeforeSort);
        driver.quit();
    }

}

