package org.Pages;

import org.Utility.Common;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends Common {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchBox;

    @FindBy(xpath = "//input[@id='gh-btn']")
    private WebElement searchBtn;

    @FindBy(xpath = "((//div[contains(text(),'Fiction & Nonfiction Books')])[1]/following::img)[1]")
    private WebElement firstItem;

    public void startApplication(){
       startApplication("https://www.ebay.com/");
    }

    public void searchItem(String item) {
        inputToTextBox(searchBox, item);
        click(searchBtn);
    }

    public void clickOnfirstItem(){
        click(firstItem);
    }



}