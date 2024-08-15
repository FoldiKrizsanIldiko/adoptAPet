package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.LoginPage;
import fki.adoptAPet.PageFactory.NavbarPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginStepDefinitions {

    WebDriver driver = new ChromeDriver();
    NavbarPage navbarPage= new NavbarPage(driver);
    LoginPage loginPage= new LoginPage(driver);

    @Before("@login")
    public void setDriverToReusableStepDefinitions() {
        ReusableStepDefinitions.setDriver(driver);
    }

    @When("I click on Login button")
    public void iClickOnLoginButton() {
        navbarPage.goToLoginPage();
    }

    @Then("I am logged in successfully")
    public void iAmLoggedInSuccessfully() {
        navbarPage.HelloUserIsVisible();
    }

    @And("I am redirected to the page with adoptable pets")
    public void iAmRedirectedToThePageWithAdoptablePets() {
        String expectedUrl= "http://localhost:4200/adopt";
        String currentUrl =ReusableStepDefinitions.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
    }


    @When("I submit login form with valid credentials")
    public void iSubmitLoginFormWithValidCredentials() {
        loginPage.inputCredentials();
    }

    @After("@login")
    public void TearDown(){
        driver.quit();
    }
}
