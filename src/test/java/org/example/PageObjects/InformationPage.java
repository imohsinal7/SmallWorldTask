package org.example.PageObjects;

import org.example.Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformationPage extends BaseClass {

    public InformationPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    @CacheLookup
    private WebElement firstName;

    @FindBy(id = "last-name")
    @CacheLookup
    private WebElement lastName;

    @FindBy(id = "postal-code")
    @CacheLookup
    private WebElement postalCode;

    @FindBy(id = "continue")
    @CacheLookup
    private WebElement continueButton;

    public void fillFirstName(String first_name){
        WaitUntilElementVisible(firstName);
        firstName.isEnabled();
        firstName.clear();
        firstName.sendKeys(first_name);
    }

    public void fillLastName(String last_name){
        WaitUntilElementVisible(lastName);
        lastName.isEnabled();
        lastName.clear();
        lastName.sendKeys(last_name);
    }

    public void fillPostalCode(String postal_code){
        WaitUntilElementVisible(postalCode);
        postalCode.isEnabled();
        postalCode.clear();
        postalCode.sendKeys(postal_code);
    }

    public void clickContinueButton(){
        WaitUntilElementVisible(continueButton);
        continueButton.isDisplayed();
        continueButton.click();
    }
}
