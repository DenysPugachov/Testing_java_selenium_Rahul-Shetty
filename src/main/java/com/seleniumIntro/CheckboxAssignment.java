package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class CheckboxAssignment {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement opt1Checkbox = driver.findElement(By.id("checkBoxOption1"));

        try { // select ON
            opt1Checkbox.click();
            Assert.assertTrue(opt1Checkbox.isSelected(), "==== 1.Test fail: Opt1 is not selected!");
            System.out.println("1.Pass. Option 1 should be true, got: " + opt1Checkbox.isSelected());
        } catch (Error err) {
            System.out.println(err.getMessage());
        }

        try { // select OFF
            opt1Checkbox.click();
            Assert.assertFalse(opt1Checkbox.isSelected(), "=== 2.Test fail: Opt1 is selected!");
            System.out.println("2.Pass. Option 1 should be false, got: " + opt1Checkbox.isSelected());
        }catch(Error err){
            System.out.println(err.getMessage());
        }

        // Get number of checkboxes in current page:
        int numberOfCheckboxes = driver.findElements(By.cssSelector("input[type='checkbox")).size();
        System.out.println("Number of checkboxes in this page is: " + numberOfCheckboxes);

        driver.quit();
    }
}
