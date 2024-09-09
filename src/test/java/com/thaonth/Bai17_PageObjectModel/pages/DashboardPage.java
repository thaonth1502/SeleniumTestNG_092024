package com.thaonth.Bai17_PageObjectModel.pages;

import com.thaonth.keywords.WebUI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By menuDashboard = By.xpath("");
    private By buttonDashboardOptions = By.xpath("//div[@class='screen-options-btn']");
    private By totalInvoicesAwaitingPayment = By.xpath("(//span[normalize-space()='Invoices Awaiting Payment']/parent::div)/following-sibling::span");
    private By totalConvertedLeads = By.xpath("(//span[normalize-space()='Converted Leads']/parent::div)/following-sibling::span");
    private By totalProjectsInProgress = By.xpath("(//span[normalize-space()='Projects In Progress']/parent::div)/following-sibling::span");
    private By totalTasksNotFinished = By.xpath("(//span[normalize-space()='Tasks Not Finished']/parent::div)/following-sibling::span");
    private By checkboxQuickStatistics = By.xpath("");

    public void checkTotalInvoicesAwaitingPayment(String total){
        Assert.assertTrue(WebUI.elementIsDisplayed(driver, totalInvoicesAwaitingPayment), "FAIL!!! totalInvoicesAwaitingPayment not displayed.");
        Assert.assertEquals(WebUI.getElementText(driver, totalInvoicesAwaitingPayment), total, "FAIL!!! Total InvoicesAwaitingPayment not match.");
    }

    public void checkTotalConvertedLeads(String total){
        Assert.assertTrue(WebUI.elementIsDisplayed(driver, totalConvertedLeads), "FAIL!!! total ConvertedLeads not displayed.");
        Assert.assertEquals(WebUI.getElementText(driver, totalConvertedLeads), total, "FAIL!!! Total ConvertedLeads not match.");
    }

    public void checkTotalProjectsInProgress(String total){
        Assert.assertTrue(WebUI.elementIsDisplayed(driver, totalProjectsInProgress), "FAIL!!! ProjectsInProgress not displayed.");
        Assert.assertEquals(WebUI.getElementText(driver, totalProjectsInProgress), total, "FAIL!!! Total ProjectsInProgress not match.");
    }

    public void checkTotalTasksNotFinished(String total){
        Assert.assertTrue(WebUI.elementIsDisplayed(driver, totalTasksNotFinished), "FAIL!!! TasksNotFinished not displayed.");
        Assert.assertEquals(WebUI.getElementText(driver, totalTasksNotFinished), total, "FAIL!!! Total TasksNotFinished not match.");
    }
}
