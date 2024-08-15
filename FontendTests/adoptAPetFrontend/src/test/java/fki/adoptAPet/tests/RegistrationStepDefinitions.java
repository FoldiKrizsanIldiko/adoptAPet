package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.NavbarPage;
import fki.adoptAPet.PageFactory.RegistrationPage;
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

public class RegistrationStepDefinitions {
    WebDriver driver;
    NavbarPage navbarPage;
    RegistrationPage registrationPage;


    @Before("@registration")
    public void setDriverToReusableStepDefinitions() {
        driver = new ChromeDriver();
        navbarPage = new NavbarPage(driver);
        registrationPage = new RegistrationPage(driver);
        driver.manage().window().maximize();
        ReusableStepDefinitions.setDriver(driver);
    }

    @Given("I open the registration page")
    public void iOpenTheRegistrationPage() {
        navbarPage.openRegistrationPage();
    }

    @When("I fill the required fields with valid data")
    public void iFillTheRequiredFieldsWithValidData() {
        registrationPage.sendCorrectCredentialsToRegistrationField();
    }

    @And("I push the Register button")
    public void iPushTheRegisterButton() {
        registrationPage.submitRegistration();
    }

    @Then("I can see message about successful registration")
    public void iCanSeeMessageAboutSuccessfulRegistration() {
        String expectedMessage = "Successful registration.";
        String message = registrationPage.successMassage();
        boolean mes = message.contains(expectedMessage);
        assertTrue(mes);
    }

    @And("I am redirected to login page")
    public void iAmRedirectedToLoginPage() {
        String currentUrl = ReusableStepDefinitions.getCurrentUrl();
        String expectedLoginUrl = "http://localhost:4200/login";
        assertEquals(expectedLoginUrl, currentUrl);
    }

    @After("@registration")
    public void TearDown() {
        driver.quit();
    }
}
