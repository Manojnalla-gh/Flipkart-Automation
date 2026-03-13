package edu.school.project;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5)); //wait for the page to laod completely
        driver.get("https://www.flipkart.com/");
        driver.manage().window().maximize(); // increase the window full
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body"))); //it will wait till the popup visible
        driver.findElement(By.tagName("body")).sendKeys(Keys.ESCAPE); // once popup visible , it will close with escape

        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("mobile", Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.className("buvtMR")).click();
        Thread.sleep(3000);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[normalize-space()='Apple iPhone 17 (Black, 256 GB)']"))); //wait for  the element to find iphone 17
        element.click(); //here the varialble (element and then click)

        //when we click on iphone it opens in new window but the driver is in window(0), so we need to switch to other window(1) for that we need to use getWindowHandle().

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles()); //before switching the window tabs, we need to use method getwindowhandles,store in ArrayList ,
        driver.switchTo().window(tabs.get(1)); //here we need to switch to second window with indexing 1 for tab2
        Thread.sleep(3000);

        WebElement element1 = driver.findElement(By.xpath("//div[contains(text(),'Buy with EMI')]"));   //ele to find but emi with EMI
        JavascriptExecutor js = (JavascriptExecutor) driver; //to scroll till the exact element , use javascript executor
        Thread.sleep(3000);
        js.executeScript("arguments[0].scrollIntoView();", element1); // used scrollintoview to scroll the page
        element1.click(); // here we click the element
        Thread.sleep(3000);
        //To make payment , we need to login using ph.no or email
        WebElement phonnumber=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/main[1]/div[1]/div[1]/div[1]/section[1]/div[3]/input[1]")));
        Thread.sleep(3000);
       driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[4]/div[1]/main[1]/div[1]/div[1]/div[1]/section[1]/div[3]/input[1]")).sendKeys("1234567890");
       Thread.sleep(3000);
       //then we click on continue
       driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
    }
}