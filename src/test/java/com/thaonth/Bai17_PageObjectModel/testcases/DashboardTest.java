package com.thaonth.Bai17_PageObjectModel.testcases;

import com.thaonth.Bai17_PageObjectModel.pages.DashboardPage;
import com.thaonth.Bai17_PageObjectModel.pages.LoginPage;
import com.thaonth.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testCheckQuickStatisticsSection(){
           loginPage = new LoginPage(driver);
           loginPage.loginCRM("admin@example.com", "123456");

           dashboardPage = new DashboardPage(driver);
           dashboardPage.checkTotalInvoicesAwaitingPayment("4 / 5");
           dashboardPage.checkTotalConvertedLeads("1 / 6");
           dashboardPage.checkTotalProjectsInProgress("1 / 4");
           dashboardPage.checkTotalTasksNotFinished("7 / 8");
    }
}
