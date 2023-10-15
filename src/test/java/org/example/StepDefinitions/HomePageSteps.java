package org.example.StepDefinitions;

import cucumber.api.java.en.And;
import org.example.PageObjects.HomePage;
import org.example.Utilities.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageSteps {

    private WebDriver driver = Binding.driver;
    private WebDriverWait wait;
    private static float totalPrice;
    private static String sauceLabsBikeLightPrice;
    private static String SauceLabsBackpackPrice;

    public HomePageSteps() throws Exception {
        PropertiesReader propertiesReader = new PropertiesReader();
        this.wait = new WebDriverWait(driver, propertiesReader.getTimeout());
    }

    @And("Add Sauce Labs Backpack into cart")
    public void addSauceLabsBackpackIntoCart() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickSauceLabsBackpack();
        SauceLabsBackpackPrice = homePage.SauceLabsBackpackPrice().replace("$", "");
        setBackPackPrice(SauceLabsBackpackPrice);
        totalPrice = totalPrice +  Float.parseFloat(SauceLabsBackpackPrice);
        setTotalPrice(totalPrice);
    }

    @And("Add Sauce Labs Bike Light into cart")
    public void addSauceLabsBikeLightIntoCart() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickSauceLabsBikeLight();
        sauceLabsBikeLightPrice = homePage.SauceLabsBikeLightPrice().replace("$", "");
        setBikeLightPrice(sauceLabsBikeLightPrice);
        totalPrice = totalPrice +  Float.parseFloat(sauceLabsBikeLightPrice);
        setTotalPrice(totalPrice);
    }

    @And("I am clicking on cart Button")
    public void iAmClickingOn() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickCartButton();
    }

    @And("I am clicking on Check Out Button")
    public void iAmClickingOnCheckOutButton() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.clickCheckOutButton();
    }

    public void setBackPackPrice(String c) {
        this.SauceLabsBackpackPrice = c;
    }
    public void setBikeLightPrice(String c) {
        this.sauceLabsBikeLightPrice = c;
    }
    public void setTotalPrice(Float c) {
        this.totalPrice = c;
    }
    public String getSauceLabsBackpackPrice() {
        return this.SauceLabsBackpackPrice;
    }

    public String getSauceLabsBikeLightPrice() {
        return this.sauceLabsBikeLightPrice;
    }

    public float getTotalPrice() {
        return this.totalPrice;
    }
}
