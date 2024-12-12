package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
   private WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    private By successlbl=By.cssSelector("h2[data-qa='account-created']");
    public String isAccountCreated() {
        WebElement accountCreatedMessage=driver.findElement(successlbl);
        return accountCreatedMessage.getText();
    }
}
