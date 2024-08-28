package com.epam.uitests.pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SouceDemoPage {

    private WebDriver driver;

    @FindBy(id = 'user-name')
    private WebElement usernameField;

    @FindBy(id = 'password')
    private WebElement passwordField;

    @FindBy(id = 'login-button')
    private WebElement loginButton;

    @FindBy(id = 'logout')
    private WebElement logoutButton;

    @FindBy(className = 'inventory_item')
    private WebElement productsList;

    public SouceDemoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void logout() {
        logoutButton.click();
    }

    public boolean isProductsDisplayed() {
        return productsList.isDisplayed();
    }
}