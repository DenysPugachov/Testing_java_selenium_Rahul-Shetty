package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.time.Duration;

public class Locators2 {
    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();

        // setup driver
        System.setProperty("webdriver.gecko.driver", "/Users/denyspugachov/Documents/geckodriver");
        WebDriver driver = new FirefoxDriver();

        String url = "https://rahulshettyacademy.com/locatorspractice/";
        String userName= "Denys";
        String userPhoneNumber = "123456789";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        String tempPassword = new Locators2().getTempPassword(driver,url); // avoid static methods.
        String tempPassword = getTempPassword(driver, url);

        // fill up the logging form
        driver.get(url);
        driver.findElement(By.id("inputUsername")).sendKeys(userName);
        driver.findElement(By.name("inputPassword")).sendKeys(tempPassword);
        driver.findElement(By.className("signInBtn")).click();

        Thread.sleep(1000);
        String pTag  = driver.findElement(By.cssSelector("div[class='login-container'] p")).getText();

        // Check the id the logging success
        System.out.println(pTag);
        Assert.assertEquals(pTag, "You are successfully logged in.");

        // Compare text from header
        String h2Text = driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText();
        System.out.println(h2Text);
        Assert.assertEquals(h2Text, "Hello " + userName + ",");
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();

        driver.quit();
    }

    public static String getTempPassword(WebDriver driver, String url) throws InterruptedException {
        driver.get(url);
        driver.findElement(By.xpath("//*[text()='Forgot your password?']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='reset-pwd-btn']")).click();

        // Get temporary password from <p> tag;
        String rawPasswordText = driver.findElement(By.xpath("//p[@class='infoMsg']")).getText();
        System.out.println(rawPasswordText);
        String[] tempPasswordArray = rawPasswordText.split("'");

        String tempPassword =  tempPasswordArray[1];
        return tempPassword;
    }
}
