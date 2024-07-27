package ru.itoltec.demoautotestspringboot.pages;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class BasePage {

    @Autowired
    public WebDriver webDriver;

    @PostConstruct
    public void initBasePage() {
        PageFactory.initElements(webDriver, this);
    }

    public void navigateTo(String url) {
        webDriver.navigate().to(url);
    }

}
