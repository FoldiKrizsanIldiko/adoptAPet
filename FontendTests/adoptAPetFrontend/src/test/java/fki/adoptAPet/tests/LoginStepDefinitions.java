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
    WebDriver driver;
    NavbarPage navbarPage;
    LoginPage loginPage;

    @Before("@login")
    public void setDriverToReusableStepDefinitions() {
        driver = new ChromeDriver();
        navbarPage = new NavbarPage(driver);
        loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
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
        String expectedUrl = "http://localhost:4200/adopt";
        String currentUrl = ReusableStepDefinitions.getCurrentUrl();
        assertEquals(expectedUrl, currentUrl);
    }

    @When("I submit login form with valid credentials")
    public void iSubmitLoginFormWithValidCredentials() {
        loginPage.inputCredentials();
    }

    @And("I enter {string} as username and {string} as password")
    public void iEnterAsUsernameAndAsPassword(String arg0, String arg1) {
        loginPage.inputCredentials(arg0, arg1);
    }

    @Then("I am notified that the login failed")
    public void iAmNotifiedThatTheLoginFailed() {
        loginPage.showErrorMessage();
    }

    @After("@login")
    public void TearDown() {
        driver.quit();
    }
}
