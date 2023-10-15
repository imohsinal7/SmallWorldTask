package org.example.PageObjects;

import org.example.Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {

    public HomePage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']//parent::a//parent::div/following-sibling::div//button")
    @CacheLookup
    private WebElement sauceLabsBackpack;

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']//parent::a//parent::div/following-sibling::div//div")
    @CacheLookup
    private WebElement sauceLabsBackpackPrice;

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Bike Light']//parent::a//parent::div/following-sibling::div//div")
    @CacheLookup
    private WebElement sauceLabsBikeLightPrice;

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Bike Light']//parent::a//parent::div/following-sibling::div//button")
    @CacheLookup
    private WebElement sauceLabsBikeLight;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    @CacheLookup
    private WebElement cartButtonLogo;

    @FindBy(name = "checkout")
    @CacheLookup
    private WebElement cartButton;

    public void clickSauceLabsBackpack(){
        WaitUntilElementVisible(sauceLabsBackpack);
        sauceLabsBackpack.isDisplayed();
        sauceLabsBackpack.click();
    }

    public void clickSauceLabsBikeLight(){
        WaitUntilElementVisible(sauceLabsBikeLight);
        sauceLabsBikeLight.isDisplayed();
        sauceLabsBikeLight.click();
    }

    public String SauceLabsBackpackPrice() {

        WaitUntilElementVisible(sauceLabsBackpackPrice);
        sauceLabsBackpackPrice.isDisplayed();
        return sauceLabsBackpackPrice.getText();
    }

    public String SauceLabsBikeLightPrice() {

        WaitUntilElementVisible(sauceLabsBikeLightPrice);
        sauceLabsBikeLightPrice.isDisplayed();
        return sauceLabsBikeLightPrice.getText();
    }

    public boolean verificationHomePageAfterLoginIsDisplayed() {

        WaitUntilElementVisible(cartButtonLogo);
        cartButtonLogo.isDisplayed();
        return true;
    }
    public void clickCartButton(){
        WaitUntilElementVisible(cartButtonLogo);
        cartButtonLogo.isDisplayed();
        cartButtonLogo.click();
    }

    public void clickCheckOutButton(){
        WaitUntilElementVisible(cartButton);
        cartButton.isDisplayed();
        cartButton.click();
    }
}