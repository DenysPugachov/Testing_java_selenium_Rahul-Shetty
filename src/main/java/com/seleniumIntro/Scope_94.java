package com.seleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Scope_94 {
    private static int i;

    public static void main(String[] ars) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));

        int countOfLinks = driver.findElements(By.tagName("a")).size();
        System.out.println("number links on the page: " + countOfLinks);

        // define subSection of driver for looking only in certain section (limiting webdriver scope);
        WebElement footerDriver = driver.findElement(By.cssSelector("#gf-BIG"));
        int footerLinks = footerDriver.findElements(By.tagName("a")).size();
        System.out.println("Number links in the footer:  " + footerLinks);

        // Limit WebDriver to first column in first column of footer
        WebElement firstColumnDriver = footerDriver.findElement(By.xpath("//table[contains(@class,'gf-t')] /tbody /tr /td[1] /ul"));
        List<WebElement> linksInFirstColumn = firstColumnDriver.findElements(By.cssSelector(".gf-li > a")); // get elem with class .gf-li with direct parent of <a>
        System.out.println("linksInFirstColumnCounter = " + linksInFirstColumn.size());

        // 4. Click on every link on the column and check if new window is opening
        for (int i = 0; i < linksInFirstColumn.size(); i++) {
            // Click on link with Command(Control) key(to open link in new window)
            String clickOpenInNewWindow = Keys.chord(Keys.COMMAND, Keys.ENTER);
            firstColumnDriver.findElements(By.cssSelector(".gf-li > a")).get(i).sendKeys(clickOpenInNewWindow);
        }

        //  5. Get title of all open tabs:
        Set<String> setOfTabs = driver.getWindowHandles(); // get all open tabs
        Iterator<String> it = setOfTabs.iterator(); // setup iterator to use iterator.next();

        // pause to all tabs are finished loading
        Thread.sleep(3000);

//        while(it.hasNext()){ // if iterator has next item available
//            driver.switchTo().window(it.next()); // get next element from iterator
//            System.out.println("Title:" + driver.getTitle());
//        }

        // with enhanced for loop => for(type item: collection){
        for (String tabItem : setOfTabs) { // if iterator has next item available
            driver.switchTo().window(tabItem); // get next element from iterator
            System.out.println("Title:" + driver.getTitle());
        }

        Thread.sleep(5000);
        driver.quit();
    }
}
