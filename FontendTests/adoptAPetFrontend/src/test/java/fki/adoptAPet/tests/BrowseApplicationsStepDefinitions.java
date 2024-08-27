package fki.adoptAPet.tests;

import fki.adoptAPet.PageFactory.ApplicationsPage;
import fki.adoptAPet.PageFactory.NavbarPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BrowseApplicationsStepDefinitions {

    WebDriver driver;
    NavbarPage navbarPage;
    ApplicationsPage applicationsPage;

    @Before("@application")
    public void SetUpDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        navbarPage = new NavbarPage(driver);
        applicationsPage = new ApplicationsPage(driver);
        ReusableStepDefinitions.setDriver(driver);
    }

    @When("I click on My applications button")
    public void iClickOnMyApplicationsButton() {
        navbarPage.openMyApplicationsPage();
    }

    @Then("I can see only the pets I want to adapt or the message that I do not have application")
    public void iCanSeeOnlyThePetsIWantToAdaptOrTheMessageThatIDoNotHaveApplication() {
        assertTrue(applicationsPage.IHaveApplications() || applicationsPage.IHaveMessageNoApplications());
    }

    @And("I check out the {} checkbox")
    public void iCheckOutTheCheckbox(String arg0) {
        applicationsPage.SelectFilterForApplications(arg0);
    }

    @Then("I can see only the {} applications or message that I do not have {} application")
    public void iCanSeeOnlyTheApplicationsOrMessageThatIDoNotHaveApplication(String arg0, String arg1) {
        applicationsPage.ApplicationMessages().forEach(System.out::println);
        assertTrue(applicationsPage.ApplicationMessages().stream().allMatch(e -> e.contains(arg0)) || applicationsPage.IHaveMessageNoApplications());
    }

    @After("@application")
    public void TearDown() {
        driver.quit();
    }

}
