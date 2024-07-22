package ru.itoltec.demoautotestspringboot.pages;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@name='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    @FindBy(xpath = "//button[contains(@type, 'submit')]")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[contains(@class, 'LoginForm_error_text')]")
    private WebElement loginFormError;

    public void fillEmail(String email) {
        this.email.sendKeys(email);
    }

    public void fillPassword(String password) {
        this.password.sendKeys(password);
    }

    public void fillLoginForm(String email, String password) {
        fillEmail(email);
        fillPassword(password);
    }

    public void clickLoginButton() {
        buttonLogin.click();
    }

    public void checkError(String error) {
        Assertions.assertThat(loginFormError.getText()).isEqualTo(error);
    }
}
