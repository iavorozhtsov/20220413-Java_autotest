package IAV.HomeWork_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.BooleanUtils.and;

public class AuthPage extends AbstractPage{

    @FindBy(css = ".s-header-item__link--login")
    private WebElement loginBtn;

    @FindBy(xpath = "//button[@class=\"b-loginform-btn b-loginform-btn--login b-loginform-btn--auth b-loginform-btn--center\"]")
    private WebElement loginBtnEnabled;

    @FindBy(xpath = "//button[@class=\"b-loginform-btn b-loginform-btn--login b-loginform-btn--auth b-loginform-btn--center b-loginform-btn--disabled\"]")
    private WebElement loginBtnDisabled;

    @FindBy(id = "user")
    private WebElement loginField;

    @FindBy(id = "lj_loginwidget_password")
    private WebElement pswdField;

    @FindBy(css = ".b-loginform-checkbox__control")
    private WebElement rememberMeCheckBox;

    @FindBy(css = ".s-nav-item__name")
    private WebElement userMenu;

    @FindBy(css = ".s-header-sub-list-item__link--logout")
    private WebElement logoutBtn;

    @FindBy(xpath = "//span[@class=\"b-loginform-field__errorMsg ng-binding\"]")
    private WebElement errorMessageField;

    @FindBy(css = ".b-loginform-field__errorMsg")
    private WebElement bruteForceErr;

    public AuthPage(WebDriver driver){
        super(driver);
    }

    public AuthPage openAuth(){
        loginBtn.click();
        return this;
    }

    public AuthPage writeToLoginField(String s){
        loginField.click();
        loginField.sendKeys(s);
        return this;
    }

    public AuthPage writeToPswdField(String s){
        pswdField.click();
        pswdField.sendKeys(s);
        return this;
    }

    public boolean isLoginBtnEnabled(){
            return !isNull(loginBtnEnabled);
    }

    public boolean isLoginBtnDisabled(){
        return !isNull(loginBtnDisabled);
    }

    public void doAuth(){
        rememberMeCheckBox.click();
        loginBtnEnabled.click();
    }

    public void doSimpleAuth(String login, String psw){
        openAuth();
        writeToLoginField(login);
        writeToPswdField(psw);
        doAuth();
    }

    public String getUserMenuText(){
        return  userMenu.getText();
    }

    public void doLogout(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(userMenu).perform();

        logoutBtn.click();
    }

    public String getErrorMessage(){
        return errorMessageField.getText();
    }

    public String getBruteforceErr(){
       return bruteForceErr.getText();
    }
}
