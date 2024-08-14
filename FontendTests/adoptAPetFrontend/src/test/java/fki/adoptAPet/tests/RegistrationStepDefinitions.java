package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.NavbarPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationStepDefinitions {
    WebDriver driver = new ChromeDriver();
    NavbarPage navbarPage= new NavbarPage(driver);


    @Given("I open the registration page")
    public void iOpenTheRegistrationPage() {
        navbarPage.openRegistrationPage();
    }

    @When("I fill the required fields with valid data")
    public void iFillTheRequiredFieldsWithValidData() {

    }

    @And("I push the Register button")
    public void iPushTheRegisterButton() {
    }

    @Then("I can see message about successful registration")
    public void iCanSeeMessageAboutSuccessfulRegistration() {
    }

    @And("I am redirected to login page")
    public void iAmRedirectedToLoginPage() {
    }
}
