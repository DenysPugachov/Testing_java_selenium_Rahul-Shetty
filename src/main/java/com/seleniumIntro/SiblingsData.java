package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class SiblingsData {

    private static List<String> getListItems(WebDriver driver) {
        return driver.findElements(By.xpath("//tbody/tr/td[1]"))
                .stream()
                .map(WebElement::getText)
                .toList();
    }


    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        String fruitName = "Mango";

        try {
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
            SortedList.selectItemsNumber(20, driver);
            // check if provide fruit exist in  a list
            List<String> listOfFruits = SortedList.getListItems(driver);

            if (listOfFruits.contains(fruitName)) {
                WebElement fruitEl = driver.findElement(By.xpath("//tbody/tr/td[contains(text(), '" + fruitName + "')]"));
                String priceValue = fruitEl.findElement(By.xpath("//following-sibling::td[1]")).getText();
                System.out.println(ConsoleColors.GREEN + fruitName + " has price: " + priceValue);
            }else{
                System.out.println(ConsoleColors.RED + "Fruit " + fruitName + " is not in a list.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
//            Thread.sleep(1000);
            driver.quit();
        }
    }
}
