package com.seleniumIntro;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollWindow {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Execute javascript code inside Java
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // Scroll main window down for 500px;
        js.executeScript("window.scrollBy(0,700)");

        Thread.sleep(1000);
        // Select table window and scroll down inside selected window
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=1000");


        Thread.sleep(3000);
        driver.close();
    }
}
