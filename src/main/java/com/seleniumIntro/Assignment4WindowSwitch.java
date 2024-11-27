package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment4WindowSwitch {
    public static void main(String[] ars) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement multipleWindowLink = driver.findElement(By.cssSelector("a[href='/windows']"));
        multipleWindowLink.click();
        WebElement childWindowLink = driver.findElement(By.cssSelector("a[href='/windows/new']"));
        childWindowLink.click();

        Set<String> setOfWindows = driver.getWindowHandles();
        Iterator<String> iterator = setOfWindows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

        driver.switchTo().window(childWindow);
        String textFromChildWindow = driver.findElement(By.cssSelector(".example h3")).getText();
        System.out.println(textFromChildWindow);

        driver.switchTo().window(parentWindow);
        String textFromParentWindow = driver.findElement(By.cssSelector(".example h3")).getText();
        System.out.println(textFromParentWindow);


        Thread.sleep(1000);
        driver.switchTo().window(childWindow);
        driver.close();
        Thread.sleep(1000);
        driver.switchTo().window(parentWindow);
        driver.close();

    }
}
