package com.thaonth.Bai17_PageObjectModel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    //Khai báo biến tooàn cục
    private WebDriver driver;
    private String URL = "https://crm.anhtester.com/admin/authentication";

    public LoginPage(WebDriver driver){
        this.driver = driver; //Nhận giá trị driver từ bên ngoài (Base Test) khi khởi tạo class
    }

    //Khai báo các element dạng đối tượng By
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By buttonLogin = By.xpath("//button[normalize-space()='Login']");
    private By errorMessage = By.xpath("//div[contains(@class,'alert')]");
    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");


    //Khai báo các hàm xử lý thuộc trang Login
    public void enterEmail(String email){
        driver.findElement(inputEmail).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(inputPassword).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(buttonLogin).click();
    }

    public void loginCRM(String email, String password){
        driver.get(URL);
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public void verifyLoginSuccess(){
        Assert.assertTrue(driver.findElement(menuDashboard).isDisplayed(), "FAIL!!! Can not redirect to Dashboard page.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://crm.anhtester.com/admin/", "FAIL!!! Current page not match.");
    }

    public void verifyLoginFail(String messageExpected){
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "FAIL!!! Error message not displayed.");
        Assert.assertEquals(driver.findElement(errorMessage).getText(),messageExpected, "FAIL!!! The content message not match.");
    }
}
