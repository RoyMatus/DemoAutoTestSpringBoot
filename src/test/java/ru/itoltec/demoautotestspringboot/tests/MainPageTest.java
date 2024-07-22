package ru.itoltec.demoautotestspringboot.tests;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itoltec.demoautotestspringboot.pages.LoginPage;
import ru.itoltec.demoautotestspringboot.pages.MainPage;

@SpringBootTest
public class MainPageTest {

    @Autowired
    MainPage mainPage;

    @Autowired
    LoginPage loginPage;

    @Value("${app.url}")
    private String appUrl;

    private final String PLEASE_ENTER_EMAIL_AND_PASSWORD = "Please enter your email and password";
    private final String PLEASE_ENTER_VALID_EMAIL = "Please enter a valid email address";

//    @BeforeEach
//    public void setUp() {
//        mainPage.navigateTo(appUrl);
//    }

    @Test
    @SneakyThrows
    void openLoginPageTest() throws InterruptedException {
        mainPage.navigateTo(appUrl);
        mainPage.clickLoginBtn();
        Thread.sleep(10000);
    }

    @Test
    void okEmailPasswordTest() {
        mainPage.navigateTo(appUrl);
        mainPage.clickLoginBtn();
        loginPage.fillLoginForm("testemail@testdomain.com", "testPassword");
        loginPage.clickLoginButton();
    }

    @Test
    void okEmailNoPasswordTest() {
        mainPage.navigateTo(appUrl);
        mainPage.clickLoginBtn();
        loginPage.fillLoginForm("testemail@testdomain.com", "");
        loginPage.clickLoginButton();
        loginPage.checkError(PLEASE_ENTER_EMAIL_AND_PASSWORD);
    }

    @Test
    void noEmailOkPasswordTest() {
        mainPage.navigateTo(appUrl);
        mainPage.clickLoginBtn();
        loginPage.fillLoginForm("", "testPassword");
        loginPage.clickLoginButton();
        loginPage.checkError(PLEASE_ENTER_EMAIL_AND_PASSWORD);
    }

    @Test
    void emailWrongErrorTest() {
        mainPage.navigateTo(appUrl);
        mainPage.clickLoginBtn();
        loginPage.fillLoginForm("wrongtestemail", "testPassword");
        loginPage.clickLoginButton();
        loginPage.checkError(PLEASE_ENTER_VALID_EMAIL);
    }

}
