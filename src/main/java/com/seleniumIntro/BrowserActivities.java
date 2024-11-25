package com.seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserActivities {
    public static void main(String[] args){

    WebDriver driver = new ChromeDriver();

    driver.manage().window().maximize(); // run browser in full screen mode
    driver.get("https://google.com");
    driver.navigate().to("https://rahulshettyacademy.com");
    driver.navigate().back();
    driver.navigate().forward();

    }
}
