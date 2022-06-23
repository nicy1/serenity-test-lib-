package com.example.serenity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.example.serenity.navigation.NavigateActions;
import com.example.serenity.pages.StepDashBoardPage;
import com.example.serenity.pages.StepForgotPasswordPage;
import com.example.serenity.pages.StepLoginPage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Screenshots;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

@RunWith(SerenityRunner.class)
public class ApplicationLoginTests {

    @Managed
    WebDriver driver;

    @Steps
    NavigateActions navigate;

    @Steps
    StepLoginPage loginPage;

    @Steps
    StepDashBoardPage dashboardPage;

    @Steps
    StepForgotPasswordPage forgetPasswordPage;

    @Test
    @Title("Login to application with valid credentials navigates to DashBoard page")
    @Screenshots
    public void successfulLogin() {

        // Given
        navigate.toTheHomePage();

        // When
        loginPage.inputUserName("Admin");
        loginPage.inputPassword("admin123");
        loginPage.clickLogin();

        // Then
        Serenity.reportThat("Passing valid credentials navigates to DashBoard page",
            () -> assertThat(dashboardPage.getHeading()).isEqualToIgnoringCase("DashBoard"));
    }

    @Test
    @Title("Login to application with invalid credential generates error message")
    @Screenshots
    public void unsuccessfulLogin() {

        // Given
        navigate.toTheHomePage();

        // When
        loginPage.inputUserName("Admin");
        loginPage.inputPassword("admin1232");
        loginPage.clickLogin();

        // Then
        Serenity.reportThat("Passing invalid credentials generates error message",
            () -> assertThat(loginPage.loginPageErrorMessage()).isEqualToIgnoringCase("Invalid credentials"));
    }

    @Test
    @Title("Verify Forgot your password link")
    @Screenshots
    public void clickForgetPasswordLink() {

        // Given
        navigate.toTheHomePage();

        // When
        loginPage.clickForgetPasswordLink();

        // Then
        Serenity.reportThat("Open Forget Password Page after clicking forget password link",
            () -> assertThat(forgetPasswordPage.getHeadingForgetPasswordPage())
                .isEqualToIgnoringCase("Forgot Your Password?"));
    }
}