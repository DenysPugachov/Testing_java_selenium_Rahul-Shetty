package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Calendar63 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        WebElement inputRadioRoundTrip = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
        inputRadioRoundTrip.click();

        // .isEnabled() => Do NOT work!  because of use of 'opacity: 0.5;" attribute to disable calendar;
//        boolean isReturnDateEnabled = driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled();
//        System.out.println("Is calendar 'return date' enabled? => " + isReturnDateEnabled);

        WebElement divCalendarReturnDate = driver.findElement(By.id("Div1"));

        // check is opacity: 1?
        boolean isOpacityAttribFull = divCalendarReturnDate.getAttribute("style").contains("opacity: 1");
        System.out.println("Is RETURN DATE calendar enabled? => " + isOpacityAttribFull);




//        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();  // Open *FROM table
//        Thread.sleep(1000);
//        driver.findElement(By.cssSelector("a[value='BLR']")).click(); // Select Bengaluru(BLR)
//        driver.findElement(By.cssSelector(
//                "div[id='ctl00_mainContent_ddl_destinationStation1_CTNR'] a[value='MAA']")).click();// *to select Chennai (MAA)
//
//        // Select current day in calendar
////        Thread.sleep(1000);
//        driver.findElement(By.cssSelector("a[class*='ui-state-highlight']")).click();

//        driver.quit();
    }
}
