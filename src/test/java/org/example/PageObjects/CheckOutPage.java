package org.example.PageObjects;

import org.example.Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends BaseClass{

    public CheckOutPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']//parent::a/following-sibling::div//div")
    @CacheLookup
    private WebElement checkOutSauceLabsBackpackPrice;

    @FindBy(xpath = "//div[@class='inventory_item_name' and text()='Sauce Labs Bike Light']//parent::a//following-sibling::div//div")
    @CacheLookup
    private WebElement checkOutSauceLabsBikeLightPrice;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    @CacheLookup
    private WebElement totalPrice;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    @CacheLookup
    private WebElement taxPrice;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    @CacheLookup
    private WebElement checkOutPrice;

    @FindBy(id = "finish")
    @CacheLookup
    private WebElement finishButton;

    @FindBy(xpath = "//div[@class='complete-text']\t")
    @CacheLookup
    private WebElement successCheckOutText;

    public String SuccessCheckOutMessage() {

        WaitUntilElementVisible(successCheckOutText);
        successCheckOutText.isDisplayed();
        return successCheckOutText.getText();
    }

    public void clickFinishButton(){
        WaitUntilElementVisible(finishButton);
        finishButton.isDisplayed();
        finishButton.click();
    }

    public String SauceLabsBackpackPrice() {

        WaitUntilElementVisible(checkOutSauceLabsBackpackPrice);
        checkOutSauceLabsBackpackPrice.isDisplayed();
        return checkOutSauceLabsBackpackPrice.getAttribute("innerHTML");
    }

    public String SauceLabsBikeLightPrice() {

        WaitUntilElementVisible(checkOutSauceLabsBikeLightPrice);
        checkOutSauceLabsBikeLightPrice.isDisplayed();
        return checkOutSauceLabsBikeLightPrice.getAttribute("innerHTML");
    }

    public String TotalPrice() {

        WaitUntilElementVisible(totalPrice);
        totalPrice.isDisplayed();
        return totalPrice.getText();
    }

    public String TaxPrice() {

        WaitUntilElementVisible(taxPrice);
        taxPrice.isDisplayed();
        return taxPrice.getText();
    }

    public String CheckOutTotalPrice() {

        WaitUntilElementVisible(checkOutPrice);
        checkOutPrice.isDisplayed();
        return checkOutPrice.getText();
    }

}
