package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        // get Actions class instance
        Actions actions = new Actions(driver);
        WebElement buttonAccept = driver.findElement(By.id("L2AGLb"));
        actions.moveToElement(buttonAccept).build().perform();

        Thread.sleep(1000);
        buttonAccept.click();
        driver.manage().window().maximize();

        WebElement searchInput = driver.findElement(By.id("APjFqb"));
//        searchInput.sendKeys("Pogoda Wroclaw");
        // Enter capital letter with Shift pressed down
        actions.moveToElement(searchInput).click().keyDown(Keys.SHIFT).sendKeys("Pogoda Wroclaw").doubleClick().build().perform();

        WebElement googleApps = driver.findElement(By.cssSelector(".gb_A"));
        actions.moveToElement(googleApps).contextClick().build().perform();

//        WebElement searchBtn = driver.findElement(By.cssSelector("input[value='Google Search']"));
//        searchBtn.click();


        Thread.sleep(3000);
        driver.close();
    }
}
