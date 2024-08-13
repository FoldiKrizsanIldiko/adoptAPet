package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.HomePage;
import fki.adoptAPet.PageFactory.NavbarPage;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowsePetsStepDefinitions {

    WebDriver driver = new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    NavbarPage navbarPage = new NavbarPage(driver);


    @Given("I am on home page")
    public void iAmOnHomePage() {
        homePage.openHomePage();
    }

    @When("I click on Adoptable pets button")
    public void iClickOnAdoptablePetsButton() {
        navbarPage.openAdoptable_petsPage();
    }

    @Then("I can see if there are any pets for adoption")
    public void iCanSeeIfThereAreAnyPetsForAdoption() {

    }

    @When("I click on the selector")
    public void iClickOnTheSelector() {
    }

    @When("I choose {}")
    public void iChoose(String arg0) {
    }

    @Then("I can see only {} types of animal or message that there are no animals of this type")
    public void iCanSeeOnlyTypesOfAnimalOrMessageThatThereAreNoAnimalsOfThisType(String arg0) {
    }

    @After("@browsePets")
    public void tearDown() {
        driver.close();
    }


}
