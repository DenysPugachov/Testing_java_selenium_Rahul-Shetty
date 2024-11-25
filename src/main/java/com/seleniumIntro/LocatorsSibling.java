package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorsSibling {
    public static void main(String[] args){
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        // Locate button
       String btnText = driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText();
       // Different way to locate the same button
       String btnText2 =  driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText();
        System.out.println(btnText);
        System.out.println(btnText2);

        driver.quit();
    }
}
