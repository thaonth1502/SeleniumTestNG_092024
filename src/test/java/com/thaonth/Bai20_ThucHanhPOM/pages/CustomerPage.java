package com.thaonth.Bai20_ThucHanhPOM.pages;

import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.lang.ref.PhantomReference;

public class CustomerPage extends CommonPage {

    private WebDriver driver;
    private SoftAssert softAssert;

    public CustomerPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    //Elements
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private By inputSearchBox = By.xpath("//div[@id='clients_filter']/descendant::input");
    private By buttonNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By firstItemCustomerName = By.xpath("//tbody/tr[1]/td[3]/a");
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVAT = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By dropdownGroups = By.xpath("//button[@data-id='groups_in[]']");
    private By searchGroup = By.xpath("//button[@data-id='groups_in[]']/following-sibling::div//input");
    private By dropdownCurrency = By.xpath("//button[@data-id='default_currency']");
    private By searchCurrency = By.xpath("//button[@data-id='default_currency']/following-sibling::div//input");
    private By dropdownDefaultLanguage = By.xpath("//button[@data-id='default_language']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropdownCountry = By.xpath("//button[@data-id='country']");
    private By searchCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input");
    private By buttonSaveCustomer = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");
    private By alterMessage = By.xpath("//span[@class='alert-title']");


    //Create Group
    private By buttonCreateGroup = By.xpath("//div[@class='input-group-btn']");
    private By formCreateGroup = By.xpath("//div[@id='customer_group_modal']");
    private By inputNameGroup = By.xpath("//input[@id='name']");
    private By errorMessage = By.xpath("//p[@id='name-error']");
    private By buttonSaveGroup = By.xpath("//div[@id='customer_group_modal']//button[normalize-space()='Save']");




    //Hàm xử lý cho trang Customer
    //Create new Groups
    public void createNewGroup(String groupName){
        WebUI.clickElement(buttonCreateGroup);
        driver.switchTo().activeElement();
        WebUI.setText(inputNameGroup, groupName);
        WebUI.clickElement(buttonSaveGroup);
        WebUI.sleep(2);
    }

    public void verifyCreateNewGroupSuccessful(String message){
        Assert.assertTrue(WebUI.checkElementExist(alterMessage), "FAIL!!! Alert message not displayed.");
        Assert.assertEquals(WebUI.getElementText(alterMessage), message, "FAIL!!! The content message not match.");
    }
    public void verifyCreateNewGroupFail(String message){
        Assert.assertTrue(WebUI.checkElementExist(errorMessage), "FAIL!!! Error message not displayed.");
        Assert.assertEquals(WebUI.getElementText(errorMessage), message, "FAIL!!! The content error message not match.");
    }

    public void verifyGroupNameInCustomerForm(String groupName){
        selectGroup(groupName);
        Assert.assertEquals(WebUI.getAttributeElement(dropdownGroups,"title"), groupName, "FAIL!!! The Groups not match.");
    }

    //Click button Save in Create new Customer form
    public void clickSaveButton(){
        WebUI.clickElement(buttonSaveCustomer);
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.checkElementExist(alterMessage), "FAIL!!! The alter Message not display.");
        Assert.assertEquals(WebUI.getElementText(alterMessage).trim(), "Customer added successfully.", "FAIL!!! The content message not match.");
    }

    public void clickAddNewButton(){
        WebUI.clickElement(buttonNewCustomer);

    }

    public void inputDataInAddNewCustomerForm(String customerName){
        WebUI.setText(inputCompany, customerName);
        WebUI.setText(inputVAT, "10");
        WebUI.setText(inputPhone, "098765432");
        WebUI.setText(inputWebsite, "https://anhtester.com");
        selectGroup("VIP");
        selectCurrency("USD");
        selectLanguage("Vietnamese");
        WebUI.sleep(1);
        WebUI.setText(inputAddress, "Hanoi");
        WebUI.setText(inputCity, "Hanoi");
        WebUI.setText(inputState, "CauGiay");
        WebUI.setText(inputZipCode, "100000");
        selectCountry("Vietnam");
    }

    public void selectCurrency(String currency){
        WebUI.clickElement(dropdownCurrency);
        WebUI.sleep(1);
        WebUI.setText(searchCurrency, currency);
        WebUI.sleep(1);
        WebUI.setKeys(searchCurrency, Keys.ENTER);
        WebUI.sleep(1);
    }

    public void selectGroup(String groupName){
        WebUI.clickElement(dropdownGroups);
        WebUI.setText(searchGroup,groupName);
        WebUI.sleep(1);
        WebUI.setKeys(searchGroup, Keys.ENTER);
        WebUI.sleep(1);
        WebUI.clickElement(dropdownGroups);
    }

    public void selectLanguage(String languageName){
        WebUI.clickElement(dropdownDefaultLanguage);
        WebUI.clickElement(By.xpath("//span[normalize-space()='"+languageName+"']"));
    }

    public void selectCountry(String countryName){
        WebUI.clickElement(dropdownCountry);
        WebUI.setText(searchCountry,countryName);
        WebUI.setKeys(searchCountry,Keys.ENTER);
    }
    public void checkCustomerDetail(String customerName){
        WebUI.clickElement(menuCustomers);
        WebUI.setText(inputSearchBox, customerName);
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.checkElementExist(firstItemCustomerName), "FAIL!!! The customer name not display in table");
        Assert.assertEquals(WebUI.getElementText(firstItemCustomerName), customerName, "FAIL!!! The customer not match");

        WebUI.clickElement(firstItemCustomerName);

        //Check content customer detail
        softAssert = new SoftAssert();

        softAssert.assertEquals(WebUI.getAttributeElement(inputCompany,"value"), customerName, "FAIL!!! The customer Name not match.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputVAT,"value"), "10", "FAIL!!! The VAT not match.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputPhone,"value"), "098765432", "FAIL!!! The Phone not match.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputWebsite,"value"), "https://anhtester.com", "FAIL!!! The Website not match.");
        softAssert.assertEquals(WebUI.getAttributeElement(dropdownGroups,"title"), "VIP", "FAIL!!! The Groups not match.");
        softAssert.assertEquals(WebUI.getAttributeElement(dropdownCurrency,"title"), "USD", "FAIL!!! The Currency not match.");
        softAssert.assertEquals(WebUI.getAttributeElement(dropdownDefaultLanguage,"title"), "Vietnamese", "FAIL!!! The Language not match.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputAddress,"value"), "Hanoi", "FAIL!!! The Address not match.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputCity,"value"), "Hanoi", "FAIL!!! The City not match.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputState,"value"), "CauGiay", "FAIL!!! The State not match.");
        softAssert.assertEquals(WebUI.getAttributeElement(inputZipCode,"value"), "100000", "FAIL!!! The Zip Code not match.");
        softAssert.assertEquals(WebUI.getAttributeElement(dropdownCountry,"title"), "Vietnam", "FAIL!!! The Country not match.");
        softAssert.assertAll();
    }


}
