package com.seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

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
        WebDriver driver = getDriver(URL, true);


        String title = driver.getTitle();
        System.out.println(title);
        
        driver.quit();
    }
}
