package com.seleniumIntro;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;

public class ScreenShot {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        try{
            // get screenshot form window
            File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenshot, new File("/Users/denyspugachov/Pictures/screenSelenium.png"));
            System.out.println("Screenshot was saved to ...Pictures/screenSelenium.png");

            // get screenshot of certain element
            // Locate the form or element
            WebElement targetTableEl = driver.findElement(By.cssSelector(".tableFixHead"));
            // Capture screenshot of the specific element
            File screenshotOfTable = targetTableEl.getScreenshotAs(OutputType.FILE);
            // Save the screenshot to the desired location
            FileUtils.copyFile(screenshotOfTable, new File("/Users/denyspugachov/Pictures/screenshotOfTable.png"));
            System.out.println("Screenshot was saved to ...Pictures/screenshotOfTable.png");


        } catch (Exception e) {
            String errorMessage = e.getMessage().split("}")[0];
            System.out.println("Error: " + "\n" + errorMessage + "}" + "\n");
        } finally {
            Thread.sleep(4000);
            driver.quit();
        }
    }
}
