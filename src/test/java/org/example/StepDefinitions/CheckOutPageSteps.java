package org.example.StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.example.PageObjects.CheckOutPage;
import org.example.Utilities.PropertiesReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPageSteps {

    private WebDriver driver = Binding.driver;
    private WebDriverWait wait;
    public String checkOutTotalPrice;

    public CheckOutPageSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    @Then("Verify Checkout Overview page")
    public void verifyCheckoutOverviewPage() throws Exception {
        CheckOutPage checkOutPage = new CheckOutPage(driver, wait);
        HomePageSteps homePageSteps = new HomePageSteps();

        // Verifying Product Items and Total prices
        Assert.assertEquals(homePageSteps.getSauceLabsBackpackPrice(), checkOutPage.SauceLabsBackpackPrice().replace("$", ""));
        Assert.assertEquals(homePageSteps.getSauceLabsBikeLightPrice(), checkOutPage.SauceLabsBikeLightPrice().replace("$", ""));
        Assert.assertEquals(String.valueOf(homePageSteps.getTotalPrice()), checkOutPage.TotalPrice().replace("Item total: $", ""));

        // Calculating & Verifying Total price by adding tax price
        checkOutTotalPrice = String.valueOf(homePageSteps.getTotalPrice() + Float.parseFloat(checkOutPage.TaxPrice().replace("Tax: $" , "")));
        Assert.assertEquals(checkOutTotalPrice, checkOutPage.CheckOutTotalPrice().replace("Total: $", ""));

        //Clicking on Finish Button
        checkOutPage.clickFinishButton();
    }

    @And("Success Check out page with message displayed \"(.*)\"")
    public void successCheckOutPageWithMessageDisplayed(String message) {
        CheckOutPage checkOutPage = new CheckOutPage(driver, wait);
        Assert.assertEquals(message, checkOutPage.SuccessCheckOutMessage());
    }
}
