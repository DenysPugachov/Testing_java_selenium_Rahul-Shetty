package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Scope_94 {
    private static int i;

    public static void main(String[] ars) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        int countOfLinks = driver.findElements(By.tagName("a")).size();
        System.out.println("number links on the page: " + countOfLinks);

        // define subSection of driver for looking only in certain section (limiting webdriver scope);
        WebElement footerDriver = driver.findElement(By.cssSelector("#gf-BIG"));
        int footerLinks = footerDriver.findElements(By.tagName("a")).size();
        System.out.println("Number links in the footer:  " + footerLinks);

        // Limit WebDriver to first column in first column of footer
        WebElement firstColumnDriver = footerDriver.findElement(By.xpath("//table[contains(@class,'gf-t')] /tbody /tr /td[1] /ul"));
        int linksInFirstColumnCounter = firstColumnDriver.findElements(By.cssSelector("a")).size();
        System.out.println("linksInFirstColumnCounter = " + linksInFirstColumnCounter);

        // 4. Click on every link on the column and check if new window is opening
        for (int i = 0; i < linksInFirstColumnCounter; i++) {
            // Click on link with Command(Control) key(to open link in new window)
            String clickOpenInNewWindow = Keys.chord(Keys.COMMAND, Keys.ENTER);
            firstColumnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOpenInNewWindow);
        }

//        driver.close();
    }
}
