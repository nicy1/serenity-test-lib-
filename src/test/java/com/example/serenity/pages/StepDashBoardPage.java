package com.example.serenity.pages;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class StepDashBoardPage extends PageObject {

    @FindBy(xpath = "//*[@id='content']/div/div[1]/h1")
    WebElementFacade dashboardPageTitle;

    @Step("Heading of DashBoard Page")
    public String getHeading() {
        return dashboardPageTitle.getText();
    }

}
