package pom.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reg1Page {

    WebDriver driver;
    //locate name field
   private By name =By.name( "name");
    //locate email field
    By email=By.cssSelector("[data-qa='signup-email'");
    //locate button
    By signupbtn=By.cssSelector("[data-qa='signup-button']");
    public void filldata(String fname,String femail)
    {
        driver.findElement(name).sendKeys(fname);
        driver.findElement(email).sendKeys(femail);

    }
    public Reg1Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickReg()
    {
        driver.findElement(signupbtn).click();

    }
}
