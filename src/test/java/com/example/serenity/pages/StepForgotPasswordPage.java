package com.example.serenity.pages;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class StepForgotPasswordPage extends PageObject {

    @FindBy(xpath = "//*[@id='content']/div[1]/div[2]/h1")
    WebElementFacade forgetLink;

    @Step("Verify Forget Password Page ")
    public String getHeadingForgetPasswordPage() {

        return forgetLink.getText();
    }
}
