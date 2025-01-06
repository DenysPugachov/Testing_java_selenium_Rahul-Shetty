package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _chetSheet {
    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);


        WebElement elementSiblingByText = driver.findElement
                (By.xpath("//tbody/tr/td[contains(text(), 'Rice')]/following-sibling::td[1]"));

    }

}
