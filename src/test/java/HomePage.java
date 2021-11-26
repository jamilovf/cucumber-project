import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class HomePage {

    private static final String PAGE_URL = "http://automationpractice.com/";

    private static final By LOGIN_ERROR = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
    private static final By CONTACT_ERROR = By.cssSelector("#center_column > div > ol > li");
    private static final By CART_ERROR = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/p[1]");
    private static final By SEARCH_ERROR = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/p[1]");
    private static final By SEARCH_RESULT = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/h1[1]/span[2]");
    private static final By CREATE_AN_ACCOUNT_ERROR = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/ol[1]/li[1]");
    private static final By REGISTRATION_ERROR = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/p[1]");

    @FindBy(className = "login")
    private WebElement signInLink;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(xpath = "//header/div[3]/div[1]/div[1]/div[3]/div[1]/a[1]")
    private WebElement cartLink;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[2]/form[1]/button[1]")
    private WebElement searchButton;

    @FindBy(id = "SubmitCreate")
    private WebElement createAnAccountButton;

    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public Optional<String> getLoginError() {
        return getErrorMessage(LOGIN_ERROR);
    }

    public Optional<String> getContactError() {
        return getErrorMessage(CONTACT_ERROR);
    }

    public Optional<String> getCartError() {
        return getErrorMessage(CART_ERROR);
    }

    public Optional<String> getSearchError() {
        return getErrorMessage(SEARCH_ERROR);
    }

    public Optional<String> getSearchResult() {
        return getErrorMessage(SEARCH_RESULT);
    }
    
    public Optional<String> getCreateAnAccountError() {
        return getErrorMessage(CREATE_AN_ACCOUNT_ERROR);
    }

    public Optional<String> getRegistrationError() {
        return getErrorMessage(REGISTRATION_ERROR);
    }

    
    public void fillField(String field, String value) {
        getField(By.id(field)).sendKeys(value);
    }

    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }

    public WebElement getSignInLink() {
        return signInLink;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getContactUsLink() {
        return contactUsLink;
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    public WebElement getCartLink() {
        return cartLink;
    }

    public WebElement getSearchButton(){
        return searchButton;
    }

    public WebElement getCreateAnAccountButton() {
        return createAnAccountButton;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }

    private Optional<String> getErrorMessage(By errorLocator) {
        Optional<WebElement> error = getError(errorLocator);
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> getError(By errorLocator) {
        List<WebElement> elements = driver.findElements(errorLocator);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }
}