package com.example.serenity.pages;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class StepLoginPage extends PageObject {

    @FindBy(name = "txtUsername")
    WebElementFacade username;

    @FindBy(name = "txtPassword")
    WebElementFacade txtPassword;

    @FindBy(name = "Submit")
    WebElementFacade submitButton;

    @FindBy(id = "spanMessage")
    WebElementFacade errorMessage;

    @FindBy(xpath = "//*[@id='forgotPasswordLink']/a")
    WebElementFacade forgotPasswordLinkText;

    @Step("Enter Username")
    public void inputUserName(String userName) {
        $("[name='txtUsername']").sendKeys((userName));
    }

    @Step("Enter Password")
    public void inputPassword(String passWord) {
        txtPassword.sendKeys((passWord));
    }

    @Step("Click Submit Button")
    public void clickLogin() {
        submitButton.click();
    }

    @Step("Error Message on unsuccessful login")
    public String loginPageErrorMessage() {
        return errorMessage.getText();
    }

    @Step("Click Forget Password Link")
    public void clickForgetPasswordLink() {
        forgotPasswordLinkText.click();
    }
}