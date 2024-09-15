package com.thaonth.keywords;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class WebUI {

    private  static WebDriver driver;

    public WebUI(WebDriver driver){
        this.driver = driver;
    }

    public static void sleep(double second){
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean checkElementExist(By by){
        List<WebElement> listElement = driver.findElements(by);
        if(listElement.size() > 0){
            System.out.println("Element " + by + "existing.");
            return true;
        } else {
            System.out.println("Element " + by + "NOT existing.");
            return false;
        }
    }

    public static void waitForElementVisible(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementVisible(By by, int second){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(second));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void waitForElementToBeClickable(By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static void clickElement(By by){
        waitForElementToBeClickable(by);
        driver.findElement(by).click();
    }

    public static void setText(By by, String text){
        waitForElementVisible(by);
        driver.findElement(by).sendKeys(text);
    }

    public static void setKeys(By by, Keys keys){
        waitForElementVisible(by);
        driver.findElement(by).sendKeys(keys);
    }

    public static void waitForElementToBeSelected (By by){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public static boolean elementIsDisplayed(By by){
       return driver.findElement(by).isDisplayed();
    }

    public static String getElementText(By by){
       return driver.findElement(by).getText();
    }

    public static String getAttributeElement(By by, String attribute){
        waitForElementVisible(by);
       return driver.findElement(by).getAttribute(attribute);
    }

    public static WebElement getWebElement(By by){
        return driver.findElement(by);
    }

    /**
     * wait for Page loaded
     * Chờ đợi trang tải xong
     */

}
