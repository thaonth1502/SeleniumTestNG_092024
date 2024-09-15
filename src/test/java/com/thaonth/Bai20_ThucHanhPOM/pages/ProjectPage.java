package com.thaonth.Bai20_ThucHanhPOM.pages;

import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends CommonPage {

    private WebDriver driver;

    public ProjectPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        new WebUI(driver);
    }

    private By inputProjectName = By.xpath("");
    private By selectCustomer = By.xpath("");
    private By inputCustomer = By.xpath("");

public void checkCustomerInProjectForm(String customerName){
    WebUI.clickElement(selectCustomer);
    WebUI.setText(inputCustomer, customerName);

}
}
