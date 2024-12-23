package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Assignment7_table {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless"); // Run Chrome in headless mode
//        options.addArguments("--disable-gpu"); // Recommended for headless
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Get number of rows
        int rowsNumber = driver.findElements(By.cssSelector("[name='courses'] tr")).size();
        System.out.println("rowsNumber: " + rowsNumber);

        // Get number of columns
        int columnsNumber = driver.findElements(By.cssSelector("[name='courses'] th")).size();
        System.out.println("columnsNumber: " + columnsNumber);

        // Second row content
        String secondRowText = driver.findElement(By.xpath("//table[contains(@name, 'courses')]/tbody/tr[3]/td[2]")).getText();
        System.out.println("secondRowText: " + secondRowText);


        // Get Poland from autocomplete dropdown
        // start input in input field
        driver.findElement(By.id("autocomplete")).sendKeys("pol");
//        Thread.sleep(1000);
        //get the list of suggestet inputs
        List<WebElement> optionsCountry = driver.findElements(By.cssSelector("li.ui-menu-item div"));
        //loop through list of inputs an click specific Text + break out the loop
        for (WebElement optionsCountryItem : optionsCountry) {
            if (optionsCountryItem.getText().equalsIgnoreCase("Poland")) {
                optionsCountryItem.click();
                break;
            }
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
