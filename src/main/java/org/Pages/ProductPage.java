package org.Pages;

import org.Utility.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends Common {
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addToCart;

    @FindBy(xpath = "//li[@id='gh-minicart-hover']/descendant::i")
    private WebElement cartAmount;

    public void clickOnAddToCartBtn(){
        switchToNewTab();
        click(addToCart);
    }

    public int getCartNumber(){
        int cartValue= Integer.parseInt(extractTextFromElement(cartAmount));
        return cartValue;
    }
}
