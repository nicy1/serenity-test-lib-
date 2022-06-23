package com.example.serenity.navigation;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class NavigateActions extends UIInteractionSteps {

    @Step
    public void toTheHomePage() {
        // openUrl("https://opensource-demo.orangehrmlive.com/");

        openPageNamed("loginForm");
    }
}