package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultipleWindows {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Utils.initChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.TAB);
        Set<String> windowHandler = driver.getWindowHandles();
        Iterator<String> it = windowHandler.iterator();

        String parentWindowId = it.next();
        String childWindowId = it.next();

        driver.switchTo().window(childWindowId);
        driver.get("https://rahulshettyacademy.com/");

        List<WebElement> coursesTitles = driver.findElements(By.xpath("//a[contains(@href, 'https://courses.rahulshettyacademy.com/p/')]"));
        String firstCourseTitle = coursesTitles.get(1).getText();
        System.out.println(firstCourseTitle);

        driver.switchTo().window(parentWindowId);

        List <WebElement> inputElems = driver.findElements(By.xpath("//input"));
        inputElems.get(0).sendKeys(firstCourseTitle);





        Thread.sleep(5000);
        driver.quit();
    }
}
