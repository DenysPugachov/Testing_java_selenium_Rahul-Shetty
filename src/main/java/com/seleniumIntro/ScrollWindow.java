package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.lang.reflect.Array;
import java.util.List;

public class ScrollWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Execute javascript code inside Java
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll main window down for 500px;
        js.executeScript("window.scrollBy(0,700)");
        Thread.sleep(1000);
        // Select table window and scroll down inside selected window
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");

        // Count Amount in table
        List<WebElement> tdElements = driver.findElements(By.cssSelector("#product td:nth-child(4)"));
        int actualSum = 0;

        for (int i = 0; i < tdElements.size(); i++) {
            int tdValue = Integer.parseInt(tdElements.get(i).getText());
            actualSum = actualSum + tdValue;
        }

        // Compare values
        String textAmount = driver.findElement(By.cssSelector(".totalAmount")).getText();
        String[] amountStringArr = textAmount.split(" ");
        int expectedSum = Integer.parseInt(amountStringArr[amountStringArr.length - 1]);

        // Test
        Assert.assertEquals(expectedSum, actualSum, "Sums are not equal!");

        System.out.println("expectedSum = " + expectedSum);
        System.out.println("actualSum = " + actualSum);
        System.out.println("Test is passed!");

        Thread.sleep(3000);
        driver.close();
    }
}