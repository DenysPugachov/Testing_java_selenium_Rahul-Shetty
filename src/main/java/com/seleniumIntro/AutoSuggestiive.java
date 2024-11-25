package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class AutoSuggestiive {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.findElement(By.id("autosuggest")).sendKeys("ger");
        Thread.sleep(1000);
        List<WebElement> optionsList = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li[class='ui-menu-item']"));

        for(WebElement optionItem: optionsList){
            String itemText = optionItem.getText();
            if(itemText.equalsIgnoreCase("Germany")){
                System.out.println("Match: " + itemText);
                optionItem.click();
                break;
            }
                System.out.println("Not match: " + itemText);
        }

//        driver.quit();
    }
}
