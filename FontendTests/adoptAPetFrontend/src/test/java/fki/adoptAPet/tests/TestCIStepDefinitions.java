package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.GoogleSite;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCIStepDefinitions {

    WebDriver driver;
    GoogleSite googleSite;

    @Before("@testCI")
    public void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        ReusableStepDefinitions.setDriver(driver);
        googleSite = new GoogleSite(driver);
    }

    @Given("Open google.com homepage")
    public void openGoogleComHomepage() {
        googleSite.OpenGooglePage();
    }

    @When("the page is opened")
    public void thePageIsOpened() {
        String expected = "https://www.google.com/";
        assertEquals(expected, ReusableStepDefinitions.getCurrentUrl());
    }

    @Then("I can see Google logo")
    public void iCanSeeGoogleLogo() {
        googleSite.GoogleSignIsDisplayed();
    }

    @After("@testCI")
    public void TearDown() {
        driver.quit();
    }
}
