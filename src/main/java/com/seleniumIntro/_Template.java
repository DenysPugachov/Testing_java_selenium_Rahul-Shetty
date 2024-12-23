package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class _Template {

    public static void main(String[] args) throws InterruptedException {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
//        driver.manage().deleteCookieNamed("cookies name "); // e.g. delete " sessionKey" cookie to redirect to logging page
        String url = "https://rahulshettyacademy.com/AutomationPractice/";
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        try{
            //
        } catch (Exception e) {
            String errorMessage = e.getMessage().split("}")[0];
            System.out.println("Error: " + "\n" + errorMessage + "}" + "\n");
        } finally {
            System.out.println("finally executed");
            Thread.sleep(4000);
            driver.quit();
        }
    }

    private static void clearFinally(WebDriver driver) throws InterruptedException {
        System.out.println("finally executed");
        Thread.sleep(2000);
        driver.close();
        Thread.sleep(4000);
        driver.quit();
    }
}
