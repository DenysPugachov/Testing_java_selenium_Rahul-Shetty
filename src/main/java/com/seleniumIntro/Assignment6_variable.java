package com.seleniumIntro;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Assignment6_variable {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        // 1. Get checkbox
        WebElement option3Elem = driver.findElement(By.id("checkBoxOption3"));
        option3Elem.click();

        // 2. Get text form parent elem label
        WebElement label3Elem = driver.findElement(By.xpath("//input[@id='checkBoxOption3'] /parent::label"));
        String labelText = label3Elem.getText();

        // 3. Select labelText from dropDown
        WebElement dropElement = driver.findElement(By.id("dropdown-class-example"));
        Select objDropDownSelect = new Select(dropElement);
        objDropDownSelect.selectByVisibleText(labelText);

        // 4. Enter in text edit box string from variable
        WebElement textInputBox = driver.findElement(By.id("name"));
        textInputBox.sendKeys(labelText);

        // 5. Click Alert
        WebElement alertBtn = driver.findElement(By.id("alertbtn"));
        alertBtn.click();

        // 6. Verify is text present in alert message
        // Switch focus to alert
        Alert alertWindow = driver.switchTo().alert();
        // Get text from alert
        String textAlert = driver.switchTo().alert().getText();
        // Get second word from text
        String secondWord = textAlert.split(" ")[1];
        // Delete coma ","
        String clearSecondWord = secondWord.split(",")[0];
        // Compare strings from alert with text form label
        if (clearSecondWord.equals(labelText)) {
            System.out.println("Success string are equal!");
        } else {
            System.out.println("Something went wrong string are not equal:" + clearSecondWord + labelText);
        }
        Thread.sleep(1000);
        // Click "ok" to alert window
        alertWindow.accept();

        // Pause before close the window
        Thread.sleep(2000);
        driver.quit();
    }
}
