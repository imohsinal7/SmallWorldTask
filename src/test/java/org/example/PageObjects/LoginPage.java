package org.example.PageObjects;

import org.example.Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseClass {

    public LoginPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "user-name")
    @CacheLookup
    private WebElement usernameField;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement passwordField;

    @FindBy(name = "login-button")
    @CacheLookup
    private WebElement signInButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    @CacheLookup
    private WebElement errorMessageLabel;

    @FindBy(xpath = "//div[@class='login_logo' and text()='Swag Labs']")
    @CacheLookup
    private WebElement logohomepage;
    public void inputUserNameData(String username_Value) {

        WaitUntilElementVisible(usernameField);
        usernameField.isEnabled();
        usernameField.clear();
        usernameField.sendKeys(username_Value);
    }

    public void inputPasswordData(String password_Value) {

        WaitUntilElementVisible(passwordField);
        passwordField.isEnabled();
        passwordField.clear();
        passwordField.sendKeys(password_Value);
    }

    public void clickSignInButton() {

        WaitUntilElementVisible(signInButton);
        signInButton.isEnabled();
        signInButton.click();
    }

    public boolean invalidCredentialserrorMessageIsDisplayed() {

        WaitUntilElementVisible(errorMessageLabel);
        errorMessageLabel.isDisplayed();
        return true;
    }

    public void loginSuccessVerification() {

        WaitUntilElementVisible(logohomepage);
        logohomepage.isDisplayed();
//        WaitUntilElementVisible(passwordField);
//        passwordField.isDisplayed();
//        WaitUntilElementVisible(signInButton);
//        signInButton.isDisplayed();
    }
}