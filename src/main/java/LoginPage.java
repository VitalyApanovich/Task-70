import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class LoginPage extends Page{
    private final static String TITLE = "RMSys - Sign In";
    @FindBy(name = "Username")
    private WebElement usernameInput;
    @FindBy(css = "input[ type ='password']")
    private WebElement passwordInput;
    @FindBy(xpath = ".//*[@id='SubmitButton']")
    private WebElement loginButton;

    LoginPage() {
        super(TITLE);
        PageFactory.initElements(driver, this);
    }

    HomePage login(String login, String pass) {
        usernameInput.sendKeys(login);
        passwordInput.sendKeys(pass);
        getLoginButton().click();
        Waiter.explicitWait(20);
        return new HomePage();
    }

    WebElement getLoginButton() {
        return loginButton;
    }

}
