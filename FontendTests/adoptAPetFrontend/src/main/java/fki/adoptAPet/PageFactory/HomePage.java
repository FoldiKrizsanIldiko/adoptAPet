package fki.adoptAPet.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomePage {
    WebDriver chromedriver;
    String URL = "http://localhost:4200/home";

    public HomePage(WebDriver driver) {
        this.chromedriver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    public void openHomePage() {
        chromedriver.get(URL);
    }
}
