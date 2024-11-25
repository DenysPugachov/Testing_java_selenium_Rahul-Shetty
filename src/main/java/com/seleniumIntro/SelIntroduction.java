package com.seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {
    public static void main(String[] args) {

        // 1. Invoking a browser
        // Chrome => ChromeDriver => methods.close() : implementation for Chrome
        // Firefox => FirefoxDriver => method.close() : for FireFox
        // WebDriver -  parent interface of all browser interfaces (ChromeDriver, FirefoxDriver, SafariSDriver....)


        // 1.1 Selenium can NOT invoke Chrome browser directly!
        // Selenium Manager: invoke browser automatically (without specifying chromedriver.exe)

        // Chrome browser
        System.setProperty("webdriver.chrome.diver", "/Users/denyspugachov/Documents/chromedriver");
        WebDriver driver = new ChromeDriver();

        // Firefox browser
//        System.setProperty("webdriver.gecko.driver", "/Users/denyspugachov/Documents/geckodriver");
//        WebDriver driverFirefox = new FirefoxDriver();

        // MsEge browser
//        System.setProperty("webdriver.edge.driver", "/Users/denyspugachov/Documents/msedgedriver");
//        WebDriver driverEdge = new EdgeDriver();

        // hit the url
        driver.get("https://rahulshettyacademy.com/");
        System.out.println(driver.getPageSource());
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.close(); // for one window => close the current window, quitting the browser if it's the last window currently open.
//        driver.quit(); // for multiple windows => closing every associated window.
    }
}