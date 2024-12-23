package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.BasePackage.Base;
import org.Pages.HomePage;
import org.Pages.ProductPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class StepDef {
    WebDriver driver;

    HomePage hp;
    ProductPage pp;

    @Given("User opens browser and load eBAY application")
    public void user_opens_browser_and_load_e_bay_application() {
        Base base = new Base();
        base.openBrowser();
        driver = base.getDriver();
        hp = new HomePage(driver);
        hp.startApplication();

    }
    @Then("User seraches for {string}")
    public void user_seraches_for(String item) {
        hp.searchItem(item);
    }
    @Then("User clicks on the first item in the list")
    public void user_clicks_on_the_first_item_in_the_list() {
        hp.clickOnfirstItem();
    }
    @When("User clicks on Add to cart")
    public void user_clicks_on_add_to_cart() {
        pp= new ProductPage(driver);
        pp.clickOnAddToCartBtn();
    }
    @Then("User verifies the cart has been updated with appropriate number of items added")
    public void user_verifies_the_cart_has_been_updated_with_appropriate_number_of_items_added() {
        int cartValue= pp.getCartNumber();
        Assert.assertTrue("Cart Validation Failed",cartValue==1);
    }

    @After
    public void tearDown() {
        Base.quitBrowser();
    }

}
