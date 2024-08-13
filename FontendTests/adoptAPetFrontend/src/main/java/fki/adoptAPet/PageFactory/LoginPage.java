package fki.adoptAPet.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    String validUserEmail = "fki@example.com";
    String validPasswordForUser = "Password0+";

    @FindBy(css = "[data-test='email-input']")
    WebElement emailField;
    @FindBy(css = "[data-test='password-input']")
    WebElement passwordField;
    @FindBy(css = "[data-test='login-button']")
    WebElement loginButton;

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
}
