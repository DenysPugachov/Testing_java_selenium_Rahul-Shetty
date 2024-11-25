package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {
    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        String text = "Denys";

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement inputAlert = driver.findElement(By.id("name"));
        WebElement btnAlert = driver.findElement(By.id("alertbtn"));
        WebElement btnConfirm = driver.findElement(By.id("confirmbtn"));

        // Alert "ok" button;
        inputAlert.sendKeys(text);
        btnAlert.click();
        String textFormAlertWindow = driver.switchTo().alert().getText(); // Use alert driver
        System.out.println(textFormAlertWindow);
        driver.switchTo().alert().accept(); // accept alert ( click "ok" = .accept()) (click "cancel" = .dismiss());

        // Alert "ok" & "cancel" buttons;
        inputAlert.sendKeys(text);
        btnAlert.click();
        String textFormConfirmWindow = driver.switchTo().alert().getText();
        System.out.println(textFormConfirmWindow);
        driver.switchTo().alert().dismiss();

    }
}
