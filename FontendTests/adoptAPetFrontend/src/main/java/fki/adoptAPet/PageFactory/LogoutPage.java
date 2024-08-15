package fki.adoptAPet.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LogoutPage {
    WebDriver driver;

    @FindBy(css="[data-test='yes-btn']")
    WebElement yesButton;
    @FindBy(css="[data-test='message']")
    WebElement logoutMessage;

    public LogoutPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void confirmLogout(){
        yesButton.click();
    }
    public String logoutMessageIs(){
        return logoutMessage.getText();
    }

}
