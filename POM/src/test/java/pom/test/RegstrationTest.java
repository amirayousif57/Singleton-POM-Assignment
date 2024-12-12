package pom.test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pom.pages.*;
import org.testng.annotations.DataProvider;
import java.util.UUID;
import java.util.List;

public class RegstrationTest {
    public WebDriver driver;
    public HomePage homePage;
    public Reg1Page reg1Page;
    public Reg2Page reg2Page;
    public AccountPage accountPage;
    @BeforeMethod
    public void setup(){
        //driver = new ChromeDriver();
        driver= WebDriverSingleton.getInstance();
        driver.get("https://www.automationexercise.com");

        driver.manage().window().maximize();
       // driver.get("https://www.automationexercise.com");

        homePage = new HomePage(driver);
        reg1Page = new Reg1Page(driver);
        accountPage = new AccountPage(driver);
        reg2Page = new Reg2Page(driver);

    }
    public static String generateFakeEmail() {
        // Generate a random UUID as the unique part of the email
        String uniqueID = UUID.randomUUID().toString().substring(0, 8); // Get a short version

        // Concatenate to form the email address
        String email = "user" + uniqueID + "@example.com";

        return email;
    }
    @Test(dataProvider = "signupData")
    public void testRegetration(String username,String password,String days,String months,String year,String fname,String name,String address,String country,String state,String city,String zip)
    {
        String fakeemail=generateFakeEmail();
        //click on regestration linkl in homepage
        homePage.clickReg();
        //fill in email and name in first regstration page
        reg1Page.filldata(username,fakeemail);
        //click on Register
        reg1Page.clickReg();
        //fill all data fields

      //  reg2Page.fillAllfields("ayaya","13","May","1992","amira","amira","gamal abdlenasser rd, 112342, qualitylab, etc.","Canada","Acnada","Canada","1123");
        reg2Page.fillAllfields(password,days,months,year,fname,name,address,country,state,city,zip);
        //click on regestier
        reg2Page.cLicksignup2();

        //assert on success msg
        Assert.assertEquals(accountPage.isAccountCreated().toLowerCase(),"account created!");


    }
    @DataProvider(name = "signupData")
    public Object[][] signupData() {
        // Load data from the CSV file
        List<String[]> csvData = CSVLoader.loadCSV("signup_data.csv");
        Object[][] data = new Object[csvData.size()][12];

        for (int i = 0; i < csvData.size(); i++) {
            String[] row = csvData.get(i);
            data[i][0] = row[0];  // username
            data[i][1] = row[1];  // password
            data[i][2] = row[2];  // days
            data[i][3] = row[3];  // moths
            data[i][4] = row[4];  // years
            data[i][5] = row[5];  // fname
            data[i][6] = row[6];  // lname
            data[i][7] = row[7];  // address
            data[i][8] = row[8];  // country
            data[i][9] = row[9];  // state
            data[i][10] = row[10];  // city
            data[i][11] = row[11];  // zip
        }
        return data;
    }
    @AfterMethod
    public void Teardown()
    {
        WebDriverSingleton.quitDriver();
    }
}
