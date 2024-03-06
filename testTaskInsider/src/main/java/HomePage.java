import org.openqa.selenium.By;;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    By homePageLocator = By.id("navbarNavDropdown");
    By homePageCookiesAcceptButton = By.id("wt-cli-accept-all-btn");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isOnHomePage(){
        return isDisplayed(homePageLocator);
    }

    public void acceptCookies(){
        if (isDisplayed(homePageCookiesAcceptButton)){
            click(homePageCookiesAcceptButton);
        }
    }



}
