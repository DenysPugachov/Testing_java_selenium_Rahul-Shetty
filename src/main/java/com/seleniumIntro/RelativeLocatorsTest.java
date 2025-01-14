package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.*;


import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorsTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Utils.initChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement inputEl = driver.findElement(By.xpath("//input[@name='name']"));
        WebElement inputDateOfBirth = driver.findElement(By.xpath("//input[@name='bday']"));

        //use relative locator: "above"
        String labelText = driver.findElement(with(By.tagName("label")).above(inputEl)).getText();
        System.out.println("labelText: " + labelText);

        // use relative locator: "below"
        driver.findElement(with(By.tagName("input")).below(inputDateOfBirth)).sendKeys("class");

        Thread.sleep(4000);
        driver.quit();
    }
}
