package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class TestPrice {

    private static WebDriver getDriver(String url, boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        if (isHeadless) {
            options.addArguments("--headless");
        }
        WebDriver driver = new ChromeDriver(options);
        driver.get(url);
        return driver;
    }

    public static void main(String[] args) {
        String URL = "https://rahulshettyacademy.com/seleniumPractise/#/offers";
        String testVeg = "Cherry";
        WebDriver driver = getDriver(URL, true);
        List<String> priceList;

        do {
            List<WebElement> vegList = driver.findElements(By.xpath("//tbody/tr/td[1]"));
            priceList = vegList.stream()
                    .filter(el -> el.getText().contains(testVeg))
                    .map(TestPrice::getSiblingsText)
                    .toList();

            if (priceList.isEmpty()) {
                // click to next page btn
                driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
            }
        }while (priceList.isEmpty());

            System.out.println(testVeg + ": " + priceList.get(0));
            driver.quit();
        }

        private static String getSiblingsText (WebElement el){
            return el.findElement(By.xpath("//following-sibling::td[1]")).getText();
        }
    }
