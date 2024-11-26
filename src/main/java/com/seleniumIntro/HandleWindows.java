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

        String messageEmail = driver.findElement(By.cssSelector(".im-para.red")).getText();
        String[] arr =messageEmail.split(" ");
        System.out.println(arr[4]);

        Thread.sleep(2000);
        driver.close();
    }
}
