package org.example.StepDefinitions;

import org.example.PageObjects.HomePage;
import org.example.PageObjects.LoginPage;
import org.example.Utilities.PropertiesReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageSteps {

    private WebDriver driver = Binding.driver;
    private WebDriverWait wait;

    public LoginPageSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }


    @Given("^User has arrived on SwagLabs website$")
    public void userHasArrivedOnSwagLabsWebsite() {
        LoginPage login = new LoginPage(driver, wait);
        login.loginSuccessVerification();
    }
    @When("^Input username through \"([^\"]*)\" and password through \"([^\"]*)\"$")
    public void submitEmailPassword(String username_Value, String password) {
        LoginPage login = new LoginPage(driver, wait);
        login.loginSuccessVerification();
        login.inputUserNameData(username_Value);
        login.inputPasswordData(password);
        login.clickSignInButton();
    }

    @Then("Verify the Success login through displaying cart button at home Page")
    public void successLogin() {
        HomePage home = new HomePage(driver, wait);
        Assert.assertTrue(home.verificationHomePageAfterLoginIsDisplayed());
    }

    @Then("Verify the Login failed with displaying error message")
    public void loginFailed() {
        LoginPage login = new LoginPage(driver, wait);
        Assert.assertTrue(login.invalidCredentialserrorMessageIsDisplayed());
    }



}