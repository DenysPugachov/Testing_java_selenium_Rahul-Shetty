package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignmentAngular {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");
        WebElement inputName = driver.findElement(By.cssSelector("form div input[name='name']"));
        WebElement inputEmail = driver.findElement(By.cssSelector("form div input[name='email']"));
        WebElement inputPassword = driver.findElement(By.id("exampleInputPassword1"));
        WebElement checkboxIceCream = driver.findElement(By.id("exampleCheck1"));
        WebElement selectGenderElement = driver.findElement(By.id("exampleFormControlSelect1"));
        WebElement radioEmploymentStatus = driver.findElement(By.id("inlineRadio1"));
        WebElement inputDateOfBirth = driver.findElement(By.cssSelector("input[name='bday']"));
        WebElement btnSubmit = driver.findElement(By.cssSelector("input[value='Submit']"));

        inputName.sendKeys("Den");
        inputEmail.sendKeys("denpuga@gmail.com");
        inputPassword.sendKeys("passwordDen");
        checkboxIceCream.click();

        // Chose form <select>: Gender -> Male
        Select selectGender = new Select(selectGenderElement);
        selectGender.selectByVisibleText("Male");

        radioEmploymentStatus.click();
        inputDateOfBirth.sendKeys("12/02/1985");
        btnSubmit.click();

        // Confirm success
        String successText = driver.findElement(By.cssSelector("div[class*='alert-success']")).getText();
        System.out.println(successText);

        driver.quit();
    }
}
