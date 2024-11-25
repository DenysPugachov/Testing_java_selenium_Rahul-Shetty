package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

import static java.lang.System.err;

public class CheckBoxes {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        // Get all checkboxes
//        List<WebElement> checkboxesList = driver.findElements(By.cssSelector("input[type='checkbox']"));

        try {
            WebElement checkboxStudent = driver.findElement(By.id("ctl00_mainContent_chk_StudentDiscount"));
//            checkboxStudent.click();
            Assert.assertTrue(checkboxStudent.isSelected(), "Student checkbox is not selected!");
            System.out.println("Student pass!");
        } catch (Error err) {
            System.out.println(err.getMessage());
        }

        try {
            WebElement checkboxFriendAndFamily = driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily"));
            checkboxFriendAndFamily.click();
            Assert.assertTrue(checkboxFriendAndFamily.isSelected(), "Family and Friends are not selected!");
            System.out.println("Family pass!");
        } catch (Error err) {
            System.out.println(err.getMessage());
        }

        driver.quit();
    }


    public static void checkSelectedCheckboxes(WebDriver driver) {
        List<WebElement> checkboxesList = driver.findElements(By.cssSelector("input[type='checkbox']"));

        for (WebElement checkbox : checkboxesList) {
            if (checkbox.isSelected()) {
                System.out.println("Selected checkbox: " + checkbox + checkbox.getAccessibleName());
            } else {
                System.out.println("Not selected: " + checkbox + checkbox.getAccessibleName());
            }
        }
    }

}
