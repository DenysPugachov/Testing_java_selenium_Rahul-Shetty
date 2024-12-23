package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        SoftAssert softAssertion = new SoftAssert();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            String linkText = link.getText();
            assert url != null;

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("HEAD"); // get only Headers of request
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println(linkText + ": " + responseCode);

            // throw an Error in case of broken link
            softAssertion.assertTrue(responseCode < 400, linkText + ": " + responseCode);
        }

        softAssertion.assertAll();

        Thread.sleep(2000);
        driver.quit();
    }
}
