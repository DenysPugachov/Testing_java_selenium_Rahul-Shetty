package com.seleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BlockingPopUp {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");

        System.out.println("test");

        Thread.sleep(30000);
        driver.quit();
    }
}
