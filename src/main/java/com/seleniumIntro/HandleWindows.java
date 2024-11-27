package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class HandleWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        WebElement blink = driver.findElement(By.cssSelector(".blinkingText"));
        blink.click();

        // Switch tabs (windows)
        Set<String> setOfTabs = driver.getWindowHandles(); // [parentId, childId, subChildId]
        Iterator<String> iterator = setOfTabs.iterator();
        String parentId = iterator.next();
        String childId = iterator.next();
        driver.switchTo().window(childId);

        String messageWithEmail = driver.findElement(By.cssSelector(".im-para.red")).getText();
        String email = messageWithEmail.split("at")[1].trim().split(" ")[0];
        System.out.println(email);

        driver.switchTo().window(parentId);
        WebElement inputUsername = driver.findElement(By.id("username"));
        inputUsername.sendKeys(email);

        Thread.sleep(1000);
        driver.switchTo().window(childId);
        driver.close();
        driver.switchTo().window(parentId);
        Thread.sleep(2000);
        driver.close();
    }
}
