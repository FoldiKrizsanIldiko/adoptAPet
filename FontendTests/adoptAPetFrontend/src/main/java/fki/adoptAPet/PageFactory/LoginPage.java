package fki.adoptAPet.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    String validUserEmail = "tom.taylor@email.com";
    String validPasswordForUser = "String!2";

    @FindBy(css = "[data-test='email-input']")
    WebElement emailField;
    @FindBy(css = "[data-test='password-input']")
    WebElement passwordField;
    @FindBy(css = "[data-test='login-button']")
    WebElement loginButton;
    @FindBy(css = "[data-test='login-error']")
    WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        PageFactory.initElements(driver, this);
    }

    public void inputCredentials() {
        emailField.sendKeys(validUserEmail);
        passwordField.sendKeys(validPasswordForUser);
        loginButton.click();
    }

    public void inputCredentials(String username, String password) {
        emailField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void showErrorMessage() {
        errorMessage.isDisplayed();
    }
}
