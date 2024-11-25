package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UpdateDropdown {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement passengersDropdown = driver.findElement(By.id("divpaxinfo"));
        passengersDropdown.click(); // open dropdown
        Thread.sleep(500); // wait until the dropdown opens

        System.out.println("Adults before loop: " + passengersDropdown.getText());

        // Clicking 4 times with loop:
//        int i = 0;
//        while(i<4){
//            // adding adults with "+" btn
//            driver.findElement(By.id("hrefIncAdt")).click();
//            i++;
//        }

        for(int i = 0; i<4; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }

        driver.findElement(By.id("btnclosepaxoption")).click();

        System.out.println("Adults: " + passengersDropdown.getText());

        driver.quit();
    }
}
