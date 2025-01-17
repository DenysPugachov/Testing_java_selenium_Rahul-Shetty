package com.seleniumIntro;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class MultipleWindowsTestGPT {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = null;

        try {
            driver = Utils.initChromeDriver(); // Initialize WebDriver
            driver.get("https://rahulshettyacademy.com/angularpractice/");

            // Open a new tab and handle multiple windows
            String parentWindowId = driver.getWindowHandle();
            openNewTab(driver);

            // Switch to the child window
            String childWindowId = getChildWindowHandle(driver, parentWindowId);
            driver.switchTo().window(childWindowId);
            driver.get("https://rahulshettyacademy.com/");

            // Get course titles
            List<WebElement> courseTitlesElems = getElementsWithWait(driver,
                    "//h2/a[contains(@href, 'https://courses.rahulshettyacademy.com/p/')]");

            if (courseTitlesElems.isEmpty()) {
                System.out.println("No courses found!");
                return;
            }

            String firstCourseTitle = courseTitlesElems.get(0).getText();
            System.out.println("First course title: " + firstCourseTitle);

            // Switch back to the parent window
            driver.close();
            driver.switchTo().window(parentWindowId);

            // Enter the course title in the first input field
            List<WebElement> inputElements = driver.findElements(By.xpath("//input"));
            if (!inputElements.isEmpty()) {
                inputElements.get(0).sendKeys(firstCourseTitle);
                System.out.println("Course title entered in the input field.");
            } else {
                System.out.println("No input elements found!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                Thread.sleep(3000); // Wait to see the result in browser window
                driver.quit(); // Ensure the browser quits even if an exception occurs
            }
        }
    }

    private static void getScreenshotOfElem(WebElement courseTitlesElems) {
        File screenshotFile = courseTitlesElems.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("./element_screenshot.png");
        try {
            FileUtils.copyFile(screenshotFile, destinationFile);
            System.out.println("Screenshot saved to: " + destinationFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void openNewTab(WebDriver driver) {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    private static String getChildWindowHandle(WebDriver driver, String parentWindowId) {
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(parentWindowId)) {
                return handle;
            }
        }
        throw new RuntimeException("Child window handle not found!");
    }

    private static List<WebElement> getElementsWithWait(WebDriver driver, String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }
}
