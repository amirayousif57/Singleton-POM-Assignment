package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Reg2Page {
    private WebDriver driver;
    private By passwordfield=By.id("password");
    private By daysfield=By.id("days");
    private By monthsfield=By.id("months");
    private By yearfield=By.id("years");
    private By fnamefield =By.id("first_name");
    private By lnamefield=By.id("last_name");
    private By addressfield=By.id("address1");
    private By countryfield=By.id("country");
    private By statefield=By.name("state");
    private By cityfield=By.id("city");
    private By zipfield=By.id("zipcode");
    private By mobfield=By.id("mobile_number");
    private By signupbtn=By.cssSelector("[data-qa='create-account']");
    public Reg2Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void fillAllfields(String pass,String days,String months,String year,String fname,String lname,String address,
                          String country,String state,String city,String zip)
    {
        WebElement titleRadioButton = driver.findElement(By.id("id_gender2"));
        titleRadioButton.click();
        driver.findElement(passwordfield).sendKeys(pass);
        driver.findElement(daysfield).sendKeys(days);
        driver.findElement(monthsfield).sendKeys(months);
        driver.findElement(yearfield).sendKeys(year);
        driver.findElement(fnamefield).sendKeys(fname);
        driver.findElement(lnamefield).sendKeys(lname);
        driver.findElement(addressfield).sendKeys(address);
        driver.findElement(countryfield).sendKeys(country);
        driver.findElement(statefield).sendKeys(state);
        driver.findElement(cityfield).sendKeys(city);
        driver.findElement(zipfield).sendKeys(zip);
        driver.findElement(mobfield).sendKeys(zip);


    }
    public void cLicksignup2()
    {
    driver.findElement(signupbtn).click();

    }
}
