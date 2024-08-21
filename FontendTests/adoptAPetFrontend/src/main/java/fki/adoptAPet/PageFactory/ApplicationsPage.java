package fki.adoptAPet.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ApplicationsPage {
    WebDriver driver;

    public ApplicationsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @FindBy(css="[data-test='application-list-item']")
    List<WebElement> MyApplications;

    public boolean IHaveApplications(){
        return !MyApplications.isEmpty();
    }

    public List<String> MyApplicationsAre(){
       List<WebElement> resultList = MyApplications.stream().map(we->we.findElement(By.xpath(".//*[@data-test='pet-name']"))).collect(Collectors.toList());
      return resultList.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
