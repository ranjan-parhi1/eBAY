package org.Utility;

import dev.failsafe.internal.util.Assert;
import org.BasePackage.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Common extends Base {

    WebDriverWait wait;

    public Common(WebDriver driver) {
        if (driver == null) {
            throw new IllegalArgumentException("WebDriver instance is null. Ensure it's initialized before passing.");
        }
        this.driver = driver;  // Inherit WebDriver from Base
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void startApplication(String url) {
        if (driver == null) {
            throw new IllegalStateException("WebDriver instance is not initialized. Call openBrowser() first.");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void inputToTextBox(WebElement textBox,String input){
        waitForElementToBeClickable(textBox);
        click(textBox);
        textBox.sendKeys(input);
    }

    public void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    public void switchToNewTab() {
        String currentTab = driver.getWindowHandle();
        Set<String> allTabs = driver.getWindowHandles();

        for (String tab : allTabs) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
                return;
            }
        }

        throw new IllegalStateException("No new tab found to switch to.");
    }

    public String getSelectedOption(WebElement dropDown) {
        Select select = new Select(dropDown);
        WebElement selectedOption = select.getFirstSelectedOption();
        return selectedOption.getText();
    }

    public String extractTextFromElement(WebElement element){
        String str= element.getText();
        return str;
    }


}
