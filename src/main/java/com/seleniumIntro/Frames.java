package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class Frames {
    public static void main(String[] ars) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");

        // to get element form frame you need to switch to it
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        String pText = driver.findElement(By.cssSelector("#draggable p")).getText();
        System.out.println(pText);

        // define an action instance to use dragAndDrop action
        Actions action = new Actions(driver);

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        action.dragAndDrop(draggable, droppable).build().perform();

        Thread.sleep(1000);
        driver.close();
    }
}