package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;


public class EcommerceCardExplicitWait {
    public static void main(String[] args) throws InterruptedException {
        // Testing data:
        String[] testedItemsNames = {"Cucumber", "Brocolli", "Brinjal", "Tomato","Beans"};
        String testUrl = "https://rahulshettyacademy.com/seleniumPractise/";

        WebDriver driver = new ChromeDriver();
        driver.get(testUrl);


        // Implicit wait GLOBALLY  for 5 seconds until all elements renders
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Explicit wait
        WebDriverWait wait5s = new WebDriverWait(driver, Duration.ofSeconds(5));

        addItemsToBasket(driver,testedItemsNames );

        WebElement basket = driver.findElement(By.cssSelector("img[alt='Cart']"));
        WebElement proceedBasketBtn = driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]"));
        basket.click();
        proceedBasketBtn.click();

        // Use Explicit wait for input for promo code renders
        wait5s.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promocode")));
        driver.findElement(By.cssSelector("input.promocode")).sendKeys("rahulshettyacademy");// enter promo string
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        // Use Explicit wait for to the text "Promo code applied" renders
        wait5s.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        String successText = driver.findElement(By.cssSelector("span.promoInfo")).getText();
        System.out.println(successText);

    }


    public static void addItemsToBasket(WebDriver driver, String[] testedItemsNames){
        List<WebElement> productsH4Names = driver.findElements(By.xpath("//div[contains(@class,'product')] /h4"));
        List<WebElement> btnAddToCartList = driver.findElements(By.cssSelector("div[class='product-action'] button"));

        List<String> testedItemsNamesList = Arrays.asList(testedItemsNames); // Convert Array to ArrayList to use .contain();

        int coutClickRemain = testedItemsNamesList.size(); // used to stop looping when tested items array is empty;
        int counterLoopExec = 0; // count to "for loop" execution

        for (int i = 0; i < productsH4Names.size(); i++) {
            String textOfCurrentProduct = productsH4Names.get(i).getText();
            String nameOfCurrentProduct = textOfCurrentProduct.split(" ")[0];// Clean the name: "Cucumber - 1 Kg" => ["Cucumber", "-", "Kg"]
            counterLoopExec++; // count loop execution

            if (testedItemsNamesList.contains(nameOfCurrentProduct)) {
                btnAddToCartList.get(i).click(); // Click on "Add to card" button
                coutClickRemain--;
            }
            // stop iterate through cards when all tested names in tested array were used;
            if (coutClickRemain < 1) break;
        }
//        System.out.println("coutClickRemain: " + coutClickRemain);
//        System.out.println("counterLoopExec: " + counterLoopExec);
//        System.out.println("End of a program!");

    }
}
