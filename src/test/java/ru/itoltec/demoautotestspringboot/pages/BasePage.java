package ru.itoltec.demoautotestspringboot.pages;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

public class BasePage {

    @Autowired
    public WebDriver webDriver;

    @PostConstruct
    public void init() {
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo(String url) {
        webDriver.navigate().to(url);
    }
}
