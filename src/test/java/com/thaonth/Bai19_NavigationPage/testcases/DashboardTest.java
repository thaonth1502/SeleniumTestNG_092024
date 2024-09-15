package com.thaonth.Bai19_NavigationPage.testcases;

import com.thaonth.Bai19_NavigationPage.pages.DashboardPage;
import com.thaonth.Bai19_NavigationPage.pages.LoginPage;
import com.thaonth.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void testCheckQuickStatisticsSection(){
           loginPage = new LoginPage(driver);
           dashboardPage = loginPage.loginCRM("admin@example.com", "123456");

           dashboardPage.checkTotalInvoicesAwaitingPayment("4 / 5");
           dashboardPage.checkTotalConvertedLeads("1 / 6");
           dashboardPage.checkTotalProjectsInProgress("1 / 7");
           dashboardPage.checkTotalTasksNotFinished("7 / 8");
    }

    @Test
    public void testCheckSectionQuickStatisticsDisplayed(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");

        dashboardPage.clickDashboardOptionButton();
        dashboardPage.verifyQuickStatisticsSectionDisplayed();
    }
}
