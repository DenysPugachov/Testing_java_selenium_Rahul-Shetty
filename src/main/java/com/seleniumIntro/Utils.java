package com.seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Utils {

    public static WebDriver initChromeDriver(boolean isHeadless) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        if (isHeadless) {
            options.addArguments("--headless");
        }
        return new ChromeDriver(options);
    }

    public static WebDriver initChromeDriver() {
        return new ChromeDriver();
    }
}
