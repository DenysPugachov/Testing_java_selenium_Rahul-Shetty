package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StaticDropdown {
    public static void main(String[] args){

        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        // dropdown with selected tag - static
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
//        System.out.println(staticDropdown.getText());

        Select dropdown = new Select(staticDropdown);

        dropdown.selectByIndex(3); // Index
        String dropdownState = dropdown.getFirstSelectedOption().getText();
        System.out.println("First selected: " + dropdownState);
        Assert.assertEquals("USD", dropdownState);

        dropdown.selectByVisibleText("AED"); // Text
        String dropdownState2 = dropdown.getFirstSelectedOption().getText();
        System.out.println("Second selected: " + dropdownState2);
        Assert.assertEquals("AED", dropdownState2);

        dropdown.selectByValue("INR"); // Value attribute;
        String dropdownState3 = dropdown.getFirstSelectedOption().getText();
        System.out.println("Third selected: " + dropdownState3);
        Assert.assertEquals("INR", dropdownState3);


        driver.quit();
    }
}
