package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class SiblingsData {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);

        String fruitName = "Mago";

        try {
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
            SortedList.selectItemsNumber(20, driver);

            // check if provide fruit exist in  a list
            List<String> listOfFruits = SortedList.getListItems(driver);
            if (listOfFruits.contains(fruitName)) {
                String price = driver.findElement(By.xpath("//tbody/tr/td[contains(text(), '" + fruitName + "')]/following-sibling::td[1]")).getText();
                System.out.println(ConsoleColors.GREEN + fruitName + " has price: " + price);
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
