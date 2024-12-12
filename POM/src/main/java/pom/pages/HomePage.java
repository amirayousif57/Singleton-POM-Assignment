package pom.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
  private  By reglink =By.linkText("Signup / Login");
  private WebDriver driver;
  public void  clickReg()
  {
      driver.findElement(reglink).click();
  }
  public HomePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

}
