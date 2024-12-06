package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalendarTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        String year = "1985";
        String monthNumber = "2";
        String day = "12";
        String[] expectedList = {monthNumber, day , year};

        WebElement yearElem = driver.findElement(By.cssSelector("input[name='year']"));
        WebElement monthElem = driver.findElement(By.cssSelector("input[name='month']"));
        WebElement dayElem = driver.findElement(By.cssSelector("input[name='day']"));

        yearElem.sendKeys(year);
        monthElem.sendKeys(monthNumber);
        dayElem.sendKeys(day);


        List<WebElement> valuesList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

//        for (WebElement currentElem : valuesList) {
//            System.out.println(currentElem.getAttribute("value"));
//        }

        for(int i =0; i<valuesList.size(); i++){
            WebElement currElem = valuesList.get(i);
            String value = currElem.getAttribute("value");
            String testValue = expectedList[i];
            System.out.println("value = " + value);
            System.out.println("testValue = " + testValue);
            Assert.assertEquals(value, testValue);
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
