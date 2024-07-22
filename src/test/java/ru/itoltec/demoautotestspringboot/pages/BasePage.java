package ru.itoltec.demoautotestspringboot.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
