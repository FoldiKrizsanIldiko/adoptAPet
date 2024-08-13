package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.HomePage;
import fki.adoptAPet.PageFactory.LoginPage;
import fki.adoptAPet.PageFactory.NavbarPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageStepDefinitions {

    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    NavbarPage navbarPage = new NavbarPage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @When("I navigate to the home page")
    public void iNavigateToTheHomePage() {
        homePage.openHomePage();
    }

    @Then("I can see navbar")
    public void iCanSeeNavbar() {
        navbarPage.navbar_is_present();
    }

    @And("I can see welcome message")
    public void iCanSeeWelcomeMessage() {
        homePage.messagePresent();
    }

    @Then("I can see on the navbar home, adoptable pets, login and registration buttons")
    public void iCanSeeOnTheNavbarHomeAdoptablePetsLoginAndRegistrationButtons() {
        assertTrue(navbarPage.homeButtonIsVisible(), "Home button is not visible");
        assertTrue(navbarPage.adoptablePetsButtonIsVisible(), "Adoptable Pets button is not visible");
        assertTrue(navbarPage.loginButtonIsVisible(), "Login button is not visible");
        assertTrue(navbarPage.registrationButtonIsVisible(), "Registration button is not visible");

    }

    @Then("I can see home, adoptable pets, my applications and logout buttons")
    public void iCanSeeHomeAdoptablePetsMyApplicationsAndLogoutButtons() {
        assertTrue(navbarPage.homeButtonIsVisible(), "Home button is not visible");
        assertTrue(navbarPage.adoptablePetsButtonIsVisible(), "Adoptable Pets button is not visible");
        assertTrue(navbarPage.applicationButtonIsVisible(), "My application button is not visible");
        assertTrue(navbarPage.HelloUserIsVisible(), "Hello User message is not visible");
        assertTrue(navbarPage.LogoutButtonIsVisible(), "Logout button is not visible");
    }

    @When("I am logged in")
    public void iAmLoggedIn() {
        navbarPage.goToLoginPage();
        loginPage.inputCredentials();
        System.out.println("I made login");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);

        Cookie specCookie = driver.manage().getCookieNamed(".AspNetCore.Identity.Application");
        System.out.println(specCookie);
    }


    @Given("I click on Home button")
    public void iClickOnHomeButton() {
        navbarPage.openHomePage();
    }

    @When("I am NOT logged in")
    public void iAmNOTLoggedIn() {
        driver.manage().getCookies();
        System.out.println(driver.manage().getCookies() + "iamNotLoggedIn");
    }
}
