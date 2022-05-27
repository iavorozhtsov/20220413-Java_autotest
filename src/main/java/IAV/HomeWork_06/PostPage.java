package IAV.HomeWork_06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class PostPage extends AuthPage{

    @FindBy(css = ".s-header-item__link--post")
    private WebElement postBtn;

    @FindBy(css = "._yz")
    private WebElement headOfPost;

    @FindBy(css = ".public-DraftEditorPlaceholder-inner")
    private WebElement preBodyOfPost;

    @FindBy(css = "._39")
    private WebElement userMenu;

    @FindBy(css = "._w5")
    private WebElement logoutBtn;


    public PostPage(WebDriver driver) {
        super(driver);
    }

    public PostPage writeToHeadOfPost(){
        headOfPost.click();
        headOfPost.sendKeys();

        return this;
    }

    public PostPage clickPostBtn(){
        postBtn.click();
        return this;
    }

    public String getPostBthUrl(){
        return postBtn.getAttribute("href");
    }

    public String getHeaderOfPostAttrib(String attr){
        return headOfPost.getAttribute(attr);
    }

    @Override
    public void doLogout(){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(userMenu).perform();
        logoutBtn.click();
    }
}
