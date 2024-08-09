package ru.itoltec.demoautotestspringboot.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class MainPage extends BasePage {

    @Value("${app.mainPage.url}")
    private String mainPageUrl;

    @FindBy(xpath = "//div[@class=\"tnb-right-section\"]/a[@title=\"Login to your account\"]")
    private WebElement btnLogin;

    @FindBy(xpath = "//*[@id='accept-choices']")
    private WebElement btnAcceptCookies;

    public void clickLoginBtn() {
        btnLogin.click();
    }

    public void open() {
        navigateTo(mainPageUrl);
        clickAcceptCookiesBtn();
    }

    private void clickAcceptCookiesBtn() {
        try {
            btnAcceptCookies.click();
        } catch (NoSuchElementException e){
            System.out.println("Accepted cookies button is not displayed.");
        }
    }

}
