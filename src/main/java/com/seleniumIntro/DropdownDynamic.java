package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DropdownDynamic {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        /*
         // Locate the dropdown
            WebElement dropdown = driver.findElement(By.id("dropdownElementId"));

            // Create Select instance
            Select select = new Select(dropdown);

            // Select an option by visible text
            select.selectByVisibleText("Option Text");
            select.selectByValue("optionValue");
            select.selectByIndex(2); // Index starts from 0
            select.selectByVisibleText("Option Text");



         */

        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("a[value='BLR']")).click();
        driver.findElement(By.cssSelector("div[id='ctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='MAA']")).click();

        String testChildXpath = driver.findElement(By.cssSelector(
                "div[id='ctl00_mainContent_ddl_originStation1_CTNR'] a[value='MAA']")).getText();
        System.out.println(testChildXpath);

        driver.quit();
    }
}
