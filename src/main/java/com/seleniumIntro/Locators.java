package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        // Initialise driver
        WebDriver driver = new ChromeDriver();

        // 1. form
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Denys");
        driver.findElement(By.name("inputPassword")).sendKeys("testPassword");
        driver.findElement(By.className("signInBtn")).click();

        // 2. form
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit wait - timeout;
        String testPError  =  driver.findElement(By.cssSelector("p.error")).getText();
        System.out.println(testPError);
        driver.findElement(By.linkText("Forgot your password?")).click();

        // 3. form
        Thread.sleep(1000); // wait for  SPA is finished (view get stable)
        //   NOT WORKING => driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("testString");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("testMail@gmail.com");
        driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("newtestmail@gmail.com");
        driver.findElement(By.xpath("//form/input[3]")).sendKeys("982398333");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();

        // 4. form
        Thread.sleep(1000);
        //    NOT WORKING =>    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Denys");
        driver.findElement(By.cssSelector("input[name*='inputPass']")).sendKeys("rahulshettyacademy"); // tag[name*=resEx]
        driver.findElement(By.id("chkboxOne")).click(); // select checkbox
        // with xpath =>    driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();// xpath requiring all classes in element
        driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click(); // //contains[(@attribute, 'keyword')]

        // driver.close();

    }
}
