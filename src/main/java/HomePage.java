import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class HomePage extends Page{
    private final static String TITLE = "RMSys - Home";
    @FindBy(css = "[title='Sign out']")
    private WebElement logoutLink;

    HomePage() {
        super(TITLE);
        PageFactory.initElements(driver, this);
    }

    LoginPage logout() {
        getLogoutLink().click();
        return new LoginPage();
    }

    WebElement getLogoutLink() {
        return logoutLink;
    }

}
