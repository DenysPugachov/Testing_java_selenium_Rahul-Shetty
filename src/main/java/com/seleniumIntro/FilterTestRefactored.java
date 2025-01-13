package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class FilterTestRefactored {

    private static final String BASE_URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
    private static final String FILTER_TEXT = "Rice";
    private static final String NEXT_PAGE_BUTTON_XPATH = "//ul/li/a[@aria-label='Next']";
    private static final String ITEMS_NAMES_XPATH = "//tbody/tr/td[1]";
    private static final String SEARCH_FIELD_ID = "search-field";

    public static void main(String[] args) {
        List<String> allItems = fetchAllItems();
        List<String> filteredItems = fetchFilteredItems(FILTER_TEXT);
        validateFilter(allItems, filteredItems);
    }

    /**
     * Fetches all item names by navigating through pagination.
     */
    private static List<String> fetchAllItems() {
        WebDriver driver = initializeDriver(true);
        driver.get(BASE_URL);
        List<String> allItems = new ArrayList<>();

        try {
            WebElement nextPageButton = driver.findElement(By.xpath(NEXT_PAGE_BUTTON_XPATH));
            boolean hasNextPage = true;

            while (hasNextPage) {
                List<String> itemsOnCurrentPage = getItemsFromCurrentPage(driver);
                allItems.addAll(itemsOnCurrentPage);

                hasNextPage = isNextPageAvailable(nextPageButton);
                if (hasNextPage) {
                    nextPageButton.click();
                }
            }
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
        return allItems;
    }

    /**
     * Fetches the filtered items based on the search criteria.
     */
    private static List<String> fetchFilteredItems(String filterText) {
        WebDriver driver = initializeDriver(true);
        driver.get(BASE_URL);
        try {
            WebElement searchField = driver.findElement(By.id(SEARCH_FIELD_ID));
            searchField.sendKeys(filterText);
            return getItemsFromCurrentPage(driver);
        } finally {
            driver.quit();
        }
    }

    /**
     * Validates that the filtered list matches the expected filtered items.
     */
    private static void validateFilter(List<String> allItems, List<String> filteredItems) {
        List<String> expectedFilteredItems = allItems.stream()
                .filter(item -> item.contains(FILTER_TEXT))
                .toList();

        Assert.assertEquals(filteredItems, expectedFilteredItems,
                ConsoleColors.RED + "Filter validation failed: " +
                        "\nExpected: " + expectedFilteredItems +
                        "\nActual: " + filteredItems
        );
        System.out.println(ConsoleColors.GREEN + "Filter validation passed!");
    }

    /**
     * Extracts item names from the current page.
     */
    private static List<String> getItemsFromCurrentPage(WebDriver driver) {
        List<WebElement> itemElements = driver.findElements(By.xpath(ITEMS_NAMES_XPATH));
        return itemElements.stream().map(WebElement::getText).toList();
    }

    /**
     * Checks if the next page is available.
     */
    private static boolean isNextPageAvailable(WebElement nextPageButton) {
        String ariaDisabled = nextPageButton.getDomAttribute("aria-disabled");
        return !Boolean.parseBoolean(ariaDisabled);
    }

    /**
     * Initializes the WebDriver with the given URL and headless mode option.
     */
    private static WebDriver initializeDriver(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless");
        }
        return new ChromeDriver(options);
    }
}
