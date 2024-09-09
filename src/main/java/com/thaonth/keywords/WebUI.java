package com.thaonth.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebUI {

    public static void sleep(double second){
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkElementExist(WebDriver driver, By by){
        List<WebElement> listElement = driver.findElements(by);
        if(listElement.size() > 0){
            System.out.println("Element " + by + "existing.");
            return true;
        } else {
            System.out.println("Element " + by + "NOT existing.");
            return false;
        }
    }

    public static void waitForElementVisible(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible(WebDriver driver, By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToBeClickable(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static boolean elementIsDisplayed(WebDriver driver, By by){
       return driver.findElement(by).isDisplayed();
    }

    public static String getElementText(WebDriver driver, By by){
       return driver.findElement(by).getText();
    }

    /**
     * wait for Page loaded
     * Chờ đợi trang tải xong
     */
}
