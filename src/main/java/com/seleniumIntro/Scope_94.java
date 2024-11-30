package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Scope_94 {
    public static void main(String[] ars) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        int countOfLinks = driver.findElements(By.tagName("a")).size();
        System.out.println("number links on the page: " + countOfLinks);

        // define subSection of driver;
        WebElement footerDriver = driver.findElement(By.cssSelector("#gf-BIG"));
        int footerLinks = footerDriver.findElements(By.tagName("a")).size();
        System.out.println("Number links in the footer:  " + footerLinks);

        driver.close();
    }
}
