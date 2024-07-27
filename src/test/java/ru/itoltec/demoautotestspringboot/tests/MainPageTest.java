package ru.itoltec.demoautotestspringboot.tests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itoltec.demoautotestspringboot.pages.LoginPage;
import ru.itoltec.demoautotestspringboot.pages.MainPage;

@SpringBootTest
public class MainPageTest {

    @Autowired
    MainPage mainPage;
    @Autowired
    LoginPage loginPage;

    private final String PLEASE_ENTER_EMAIL_AND_PASSWORD = "Please enter your email and password";
    private final String PLEASE_ENTER_VALID_EMAIL = "Please enter a valid email address";


    @Test
    void openLoginPageTest() {
        mainPage.open();
        mainPage.clickLoginBtn();
    }

    @Test
    void okEmailPasswordTest() {
        mainPage.open();
        mainPage.clickLoginBtn();
        loginPage.fillLoginForm("testemail@testdomain.com", "testPassword");
        loginPage.clickLoginButton();
    }

    @Test
    void okEmailNoPasswordTest() {
        mainPage.open();
        mainPage.clickLoginBtn();
        loginPage.fillLoginForm("testemail@testdomain.com", "");
        loginPage.clickLoginButton();
        loginPage.checkError(PLEASE_ENTER_EMAIL_AND_PASSWORD);
    }

    @Test
    void noEmailOkPasswordTest() {
        mainPage.open();
        mainPage.clickLoginBtn();
        loginPage.fillLoginForm("", "testPassword");
        loginPage.clickLoginButton();
        loginPage.checkError(PLEASE_ENTER_EMAIL_AND_PASSWORD);
    }

    @Test
    void emailWrongErrorTest() {
        mainPage.open();
        mainPage.clickLoginBtn();
        loginPage.fillLoginForm("wrongtestemail", "testPassword");
        loginPage.clickLoginButton();
        loginPage.checkError(PLEASE_ENTER_VALID_EMAIL);
    }

}
