package org.example.StepDefinitions;

import cucumber.api.java.en.And;
import org.example.PageObjects.InformationPage;
import org.example.Utilities.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InformationSteps {
    private WebDriver driver = Binding.driver;
    private WebDriverWait wait;


    public InformationSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    @And("^I send First Name \"(.*)\" on information page")
    public void iSendFirstNameOnInformationPage(String first_name)   {
        InformationPage informationPage = new InformationPage(driver, wait);
        informationPage.fillFirstName(first_name);
    }

    @And("^I send Last Name \"(.*)\" on information page")
    public void iSendLastNameOnInformationPage(String last_name)   {
        InformationPage informationPage = new InformationPage(driver, wait);
        informationPage.fillLastName(last_name);
    }

    @And("^I send Postal Code \"(.*)\" on information page")
    public void iSendPostalCodeOnInformationPage(String postal_code)   {
        InformationPage informationPage = new InformationPage(driver, wait);
        informationPage.fillPostalCode(postal_code);
    }

    @And("^I am clicking on Continue Button on information page$")
    public void iAmClickingOnContinueButtonOnInformationPage() {
        InformationPage informationPage = new InformationPage(driver, wait);
        informationPage.clickContinueButton();
    }
}
