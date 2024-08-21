package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.AdoptPage;
import fki.adoptAPet.PageFactory.NavbarPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdoptAPetStepDefinitions {

    WebDriver driver;
    NavbarPage navbarPage;
    AdoptPage adoptPage;

    @Before("@adopt")
    public void setDriverToReusableStepDefinitions() {
        driver = new ChromeDriver();
        navbarPage = new NavbarPage(driver);
        adoptPage = new AdoptPage(driver);
        driver.manage().window().maximize();
        ReusableStepDefinitions.setDriver(driver);
    }

    @Given("I am on adopt page")
    public void iAmOnAdoptPage() {
        navbarPage.openAdoptable_petsPage();
    }

    @Given("I can see at least one adoptable pet i have not sign in for jet")
    public void iCanSeeAtLeastOneAdoptablePetIHaveNotSignInForJet() {
        assertTrue(adoptPage.thereAreAdoptablePets());
    }

    @When("I click on I'd like to adopt button")
    public void iClickOnIDLikeToAdoptButton() {
        adoptPage.clickOnAdoptAPet();
    }

    @Then("I can see a notification")
    public void iCanSeeANotification() {
        adoptPage.acceptNotification();
    }

    @And("I am redirected to My Application page")
    public void iAmRedirectedToMyApplicationPage() {
        String expectedURL = "http://localhost:4200/applications";
        assertEquals(ReusableStepDefinitions.getCurrentUrl(), expectedURL);
    }

    @Given("I am on My Application page")
    public void iAmOnMyApplicationPage() {
    }

    @Given("I have at least one application")
    public void iHaveAtLeastOneApplication() {
    }

    @And("I am redirected to adopt page")
    public void iAmRedirectedToAdoptPage() {
    }

    @Then("the I'd like to adopt button for the animal I am assigned on is disabled")
    public void theIDLikeToAdoptButtonForTheAnimalIAmAssignedOnIsDisabled() {
    }

    @When("I click on enabled I'd like to adopt button")
    public void iClickOnEnabledIDLikeToAdoptButton() {
    }

    @And("I have more than one application")
    public void iHaveMoreThanOneApplication() {
    }

    @After("@adopt")
    public void TearDown() {
        driver.quit();
    }
}
