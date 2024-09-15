package com.thaonth.Bai20_ThucHanhPOM.testcases;

import com.thaonth.Bai20_ThucHanhPOM.pages.CustomerPage;
import com.thaonth.Bai20_ThucHanhPOM.pages.DashboardPage;
import com.thaonth.Bai20_ThucHanhPOM.pages.LoginPage;
import com.thaonth.common.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        String CUSTOMER_NAME = "1509A2 CustomerName";
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        customerPage = dashboardPage.clickMenuCustomers();
        int beforeTotalCustomers = Integer.parseInt(customerPage.getTotalCustomers());
        System.out.println("Total Customer before: " + beforeTotalCustomers);
        customerPage.clickAddNewButton();
        customerPage.inputDataInAddNewCustomerForm(CUSTOMER_NAME);
        customerPage.clickSaveButton();
        customerPage.checkCustomerDetail(CUSTOMER_NAME);

        int afterTotalCustomers = Integer.parseInt(customerPage.getTotalCustomers());
        System.out.println("Total Customer after: " + afterTotalCustomers);
        Assert.assertEquals(afterTotalCustomers, beforeTotalCustomers + 1, "FAIL!!! Total Customer not match.");
    }

    @Test
    public void createNewGroupSuccess(){
        loginPage = new LoginPage(driver);
        String GROUP_NAME = "TEST A02";
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.clickAddNewButton();
        customerPage.createNewGroup(GROUP_NAME);
        customerPage.verifyCreateNewGroupSuccessful("Customer Group added successfully.");
        customerPage.verifyGroupNameInCustomerForm(GROUP_NAME);
    }

    @Test
    public void createNewGroupFail(){
        loginPage = new LoginPage(driver);
        String GROUP_NAME = "";
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
        customerPage = dashboardPage.clickMenuCustomers();
        customerPage.clickAddNewButton();
        customerPage.createNewGroup(GROUP_NAME);
        customerPage.verifyCreateNewGroupFail("This field is required.");
    }
}
