import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test70 {
    private final String LOGIN = Credentials.creds.getProperty("login");
    private final String PASS = Credentials.creds.getProperty("password");
    String imageFileName = "loginImage.png";
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void beforeMethod() {
        Driver.openLoginPage();
        loginPage = new LoginPage();
        loginPage.makeScreenShot(imageFileName);
    }

    @AfterMethod
    public void afterMethod() {
        Driver.closeDriver();
    }

    @Test
    public void loginTest() {
        homePage = loginPage.login(LOGIN, PASS);
        Assert.assertTrue(homePage.isDisplayed(), "Inbox page is not displayed");
    }
}
