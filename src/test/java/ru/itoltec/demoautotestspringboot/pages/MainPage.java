package ru.itoltec.demoautotestspringboot.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class MainPage extends BasePage {

    @FindBy(xpath = "//div[@class=\"tnb-right-section\"]/a[@title=\"Login to your account\"]")
    private WebElement btnLogin;

    public void clickLoginBtn() {
        btnLogin.click();
    }

}
