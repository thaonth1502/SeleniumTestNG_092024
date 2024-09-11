package com.thaonth.Bai20_ThucHanhPOM.pages;

import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class DashboardPage extends CommonPage {

    WebDriver driver;
    SoftAssert softAssert = new SoftAssert();

    public DashboardPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By buttonDashboardOptions = By.xpath("//div[@class='screen-options-btn']");
    private By totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");
    private By totalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");
    private By totalTasksNotFinished = By.xpath("(//span[normalize-space()='Tasks Not Finished']/parent::div)/following-sibling::span");
    private By checkboxQuickStatistics = By.xpath("//input[@id='widget_option_top_stats']");

    public void checkTotalInvoicesAwaitingPayment(String total){
        softAssert.assertTrue(WebUI.elementIsDisplayed(totalInvoicesAwaitingPayment), "FAIL!!! totalInvoicesAwaitingPayment not displayed.");
        softAssert.assertEquals(WebUI.getElementText(totalInvoicesAwaitingPayment), total, "FAIL!!! Total InvoicesAwaitingPayment not match.");
    }

    public void checkTotalConvertedLeads(String total){
        softAssert.assertTrue(WebUI.elementIsDisplayed(totalConvertedLeads), "FAIL!!! total ConvertedLeads not displayed.");
        softAssert.assertEquals(WebUI.getElementText(totalConvertedLeads), total, "FAIL!!! Total ConvertedLeads not match.");
    }

    public void checkTotalProjectsInProgress(String total){
        softAssert.assertTrue(WebUI.elementIsDisplayed(totalProjectsInProgress), "FAIL!!! ProjectsInProgress not displayed.");
        softAssert.assertEquals(WebUI.getElementText(totalProjectsInProgress), total, "FAIL!!! Total ProjectsInProgress not match.");
    }

    public void checkTotalTasksNotFinished(String total){
        softAssert.assertTrue(WebUI.elementIsDisplayed(totalTasksNotFinished), "FAIL!!! TasksNotFinished not displayed.");
        softAssert.assertEquals(WebUI.getElementText(totalTasksNotFinished), total, "FAIL!!! Total TasksNotFinished not match.");
        softAssert.assertAll();
    }

    public void clickDashboardOptionButton(){
        WebUI.waitForElementToBeClickable(buttonDashboardOptions);
        driver.findElement(buttonDashboardOptions).click();
    }

    public void verifyQuickStatisticsSectionDisplayed(){
        WebUI.elementIsDisplayed(checkboxQuickStatistics);
        Assert.assertTrue(driver.findElement(checkboxQuickStatistics).isSelected(),"FAIL!!! Checkbox Quick Statistics not selected.");
        softAssert.assertTrue(WebUI.elementIsDisplayed(totalInvoicesAwaitingPayment), "FAIL!!! totalInvoicesAwaitingPayment not displayed.");
        softAssert.assertTrue(WebUI.elementIsDisplayed(totalConvertedLeads), "FAIL!!! total ConvertedLeads not displayed.");
        softAssert.assertTrue(WebUI.elementIsDisplayed(totalProjectsInProgress), "FAIL!!! ProjectsInProgress not displayed.");
        softAssert.assertTrue(WebUI.elementIsDisplayed(totalTasksNotFinished), "FAIL!!! TasksNotFinished not displayed.");
        softAssert.assertAll();
    }
}
