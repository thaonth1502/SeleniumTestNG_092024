package com.thaonth.Bai20_ThucHanhPOM.testcases;

import com.thaonth.Bai20_ThucHanhPOM.pages.LoginPage;
import com.thaonth.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    LoginPage loginPage;

    @Test
    public void testLoginSuccess(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "123456");
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginFailWithEmailInvalid(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin111@example.com", "123456");
        loginPage.verifyLoginFail("Invalid email or password");
    }

    @Test
    public void testLoginFailWithPasswordInvalid(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "12345678");
        loginPage.verifyLoginFail("Invalid email or password");
    }

    @Test
    public void testLoginFailWithPasswordBlank(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@example.com", "");
        loginPage.verifyLoginFail("The Password field is required.");
    }

    @Test
    public void testLoginFailWithEmailBlank(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("", "12345678");
        loginPage.verifyLoginFail("The Email Address field is required.");
    }
}
