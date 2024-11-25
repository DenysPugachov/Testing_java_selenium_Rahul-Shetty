package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Assignment3LoginExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        String testedUrl = "https://rahulshettyacademy.com/loginpagePractise/";
        WebDriver driver = new ChromeDriver();
        // Explicit wait
        WebDriverWait wait5s = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get(testedUrl);

        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//span[normalize-space()='User']")).click();

        wait5s.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        driver.findElement(By.cssSelector(".form-control option[value='consult']")).click();
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

        String xPathForAddBtn = "//div[div[h4[a[contains(text(),'iphone X')]]]] /div[@class='card-footer'] /button";

        wait5s.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPathForAddBtn)));
        driver.findElement(By.xpath(xPathForAddBtn)).click();
        driver.findElement(By.xpath("//div[div[h4[a[contains(text(),'Blackberry')]]]] /div[@class='card-footer'] /button")).click();
        driver.findElement(By.xpath("//div[div[h4[a[contains(text(),'Samsung Note 8')]]]] /div[@class='card-footer'] /button")).click();
        driver.findElement(By.xpath("//li[@class='nav-item active'] /a[@class='nav-link btn btn-primary']")).click();

        Thread.sleep(5000);
        driver.close();
    }

}
