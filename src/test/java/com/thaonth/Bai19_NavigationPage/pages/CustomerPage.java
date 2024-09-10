package com.thaonth.Bai19_NavigationPage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomerPage extends CommonPage {

    private WebDriver driver;

    public CustomerPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    //Elements
    private By buttonNewCustomer = By.xpath("");
    private By inputComany = By.xpath("");
    private By inputVAT = By.xpath("");
    private By inputPhone = By.xpath("");
    private By inputWebsite = By.xpath("");
    private By dropdownGroups = By.xpath("");
    private By dropdownCurrency = By.xpath("");
    private By dropdownDefaultLanguage = By.xpath("");
    private By inputAddress = By.xpath("");
    private By inputCity = By.xpath("");
    private By inputState = By.xpath("");
    private By inputZipCode = By.xpath("");
    private By dropdownCountry = By.xpath("");



    //Hàm xử lý cho trang Customer
    public void clickAddNewButton(){

    }

    public void inputDataInAddNewCustomerForm(String customerName){

    }

    public void checkCustomerDetail(String customerName){

    }


}
